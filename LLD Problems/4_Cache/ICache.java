public abstract class ICache<K, V> {

    protected int ttlInSeconds;
    protected int maxSize;

    public ICache(int ttlInSeconds, int maxSize) {
        this.ttlInSeconds = ttlInSeconds;
        this.maxSize = maxSize;
    }

    public abstract void put(K key, V value);

    public abstract V get(K key);

    public abstract int size();

    public abstract void remove(K key);
}
