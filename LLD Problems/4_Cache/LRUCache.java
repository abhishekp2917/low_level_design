public class LRUCache<K, V> extends ICache<K, V> {

    private final int SEGMENT_COUNT;
    private ICache<K, V>[] cacheSegments;

    public LRUCache(int ttlInSeconds, int maxSize, int SEGMENT_COUNT) {
        super(ttlInSeconds, maxSize);
        this.SEGMENT_COUNT = SEGMENT_COUNT;
        this.cacheSegments = new LRUCacheSegment[this.SEGMENT_COUNT];
        int remainingSize = maxSize;
        int segmentMinSize = remainingSize/this.SEGMENT_COUNT;
        for(int i=0; i<this.SEGMENT_COUNT; i++) {
            int segmentMaxSize = (i!=this.SEGMENT_COUNT-1)? segmentMinSize : remainingSize;
            this.cacheSegments[i] = new LRUCacheSegment<>(ttlInSeconds, segmentMaxSize);
            remainingSize -= segmentMinSize;
        }
    }

    @Override
    public void put(K key, V value) {
        ICache<K, V> cacheSegment = getCacheSegmentIdx(key);
        cacheSegment.put(key, value);
    }

    @Override
    public V get(K key) {
       ICache<K, V> cacheSegment = getCacheSegmentIdx(key);
       return cacheSegment.get(key);
    }

    @Override
    public int size() {
        int size = 0;
        for(int i=0; i<this.SEGMENT_COUNT; i++) {
            size += this.cacheSegments[i].size();
        }
        return size;
    }

    @Override
    public void remove(K key) {
        ICache<K, V> cacheSegment = getCacheSegmentIdx(key);
        cacheSegment.remove(key);
    }

    private ICache<K, V> getCacheSegmentIdx(K key) {
        int segmentIdx = Math.abs(key.hashCode())%this.SEGMENT_COUNT;
        return this.cacheSegments[segmentIdx];
    }
}
