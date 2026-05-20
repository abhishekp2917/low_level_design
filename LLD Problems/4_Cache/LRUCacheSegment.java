import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class LRUCacheSegment<K, V> extends ICache<K, V> {

    private final ConcurrentMap<K, Node<K, V>> nodeMap;
    private Node<K, V> head;
    private Node<K, V> tail;
    private final IObjectPoolStrategy<Node<K, V>> nodePool;
    private final Object lock;

    public LRUCacheSegment(int ttlInSeconds, int maxSize) {
        super(ttlInSeconds, maxSize);
        this.nodeMap = new ConcurrentHashMap<>();
        this.head = new Node<>();
        this.tail = new Node<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.nodePool = new SimplePoolStrategy<>(maxSize, Node<K, V>::new);
        this.lock = new Object();
    }

    @Override
    public void put(K key, V value) {
        long expiryTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(super.ttlInSeconds);
        synchronized(lock) {
            Node<K, V> node = this.nodeMap.get(key);
            if(node==null) {
                if(this.nodeMap.size()==super.maxSize) removeExpiredEntries();
                if(this.nodeMap.size()==super.maxSize) removeLast();
                node = this.nodePool.getInstance();
                if(node == null) {
                    throw new IllegalStateException("Pool exhausted");
                }
                this.nodeMap.put(key, node);
            }
            else detach(node);
            node.key = key;
            node.value = value;
            node.expiryTime = expiryTime;
            moveFront(node);
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        long now = System.currentTimeMillis();
        synchronized(lock) {
            Node<K, V> node = this.nodeMap.get(key);
            if(node==null) return null;
            if(now>=node.expiryTime) {
                removeNode(node);
                return null;
            }
            detach(node);
            moveFront(node);
            value = node.value;
        }
        return value;
    }

    @Override
    public int size() {
        return this.nodeMap.size();
    }

    @Override
    public void remove(K key) {
        synchronized(lock) {
            Node<K, V> node = this.nodeMap.get(key);
            if(node==null) return;
            removeNode(node);
        }
    }

    private void detach(Node<K, V> node) {
        Node<K, V> prev = node.prev;
        Node<K, V> next = node.next;
        node.prev = null;
        node.next = null;
        if(prev!=null) prev.next = next;
        if(next!=null) next.prev = prev;
    }

    private void moveFront(Node<K, V> node) {
        Node<K, V> headNext = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = headNext;
        if(headNext!=null) headNext.prev = node;
    }

    private void removeLast() {
        if(this.tail.prev==this.head) return;
        Node<K, V> lastNode = this.tail.prev;
        removeNode(lastNode);
    }

    private void removeExpiredEntries() {
        long now = System.currentTimeMillis();
        for(K key : this.nodeMap.keySet()) {
            Node<K, V> node = this.nodeMap.get(key);
            if(now>=node.expiryTime) removeNode(node);
        }
    }

    private void removeNode(Node<K, V> node) {
        detach(node);
        this.nodeMap.remove(node.key);
        this.nodePool.restore(node);
    }

    private static class Node<K, V> implements Resettable {

        private K key;
        private V value;
        private long expiryTime;
        private Node<K, V> prev;
        private Node<K, V> next;

        @Override
        public void reset() {
            this.key = null;
            this.value = null;
            this.expiryTime = 0L;
            this.prev = null;
            this.next = null;
        }
    }
}
