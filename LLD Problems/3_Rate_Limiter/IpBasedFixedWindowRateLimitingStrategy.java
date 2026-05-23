import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
// import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class IpBasedFixedWindowRateLimitingStrategy implements IRateLimitingStrategy {

    private final long requestLimit;
    private final long windowSizeInSec;
    private final ConcurrentMap<String, RequestLimitWrapper> requestMap;
    // private final ConcurrentMap<String, AtomicReference<AtomicRequestLimitWrapper>> requestMap;

    public IpBasedFixedWindowRateLimitingStrategy(long requestLimit, long windowSizeInSec) {
        this.requestLimit = requestLimit;
        this.windowSizeInSec = windowSizeInSec;
        this.requestMap = new ConcurrentHashMap<>();
    }

    // 1. Synchronized based locking
    // @Override
    // public boolean isAllowed(Request request) {
    //     String ipAddress = request.getIpAddress();
    //     LocalDateTime requestReceivedAt = LocalDateTime.now();
    //     RequestLimitWrapper limitWrapper = requestMap.computeIfAbsent(
    //         ipAddress,
    //         ip -> new RequestLimitWrapper(requestReceivedAt.plusSeconds(windowSizeInSec))
    //     );
    //     synchronized(limitWrapper) {
    //         if(requestReceivedAt.compareTo(limitWrapper.getNextLimitRefreshTime())>=0) {
    //             limitWrapper.resetRequestCount();
    //             limitWrapper.setNextLimitRefreshTime(
    //                 requestReceivedAt
    //                 .plusSeconds(this.windowSizeInSec));
    //         }
    //         if(limitWrapper.getRequestCount()<this.requestLimit) {
    //             limitWrapper.incrementRequestCount();
    //             return true;
    //         }
    //         else return false;
    //     }
    // }

    // 2. Lockbased locking (Interview Friendly)
    @Override
    public boolean isAllowed(ElevatorContext request) {
        String ipAddress = request.getIpAddress();
        long requestReceivedAt = System.currentTimeMillis();
        long nextLimitRefreshTime = requestReceivedAt + TimeUnit.SECONDS.toMillis(this.windowSizeInSec);
        RequestLimitWrapper limitWrapper = requestMap.computeIfAbsent(
            ipAddress,
            ip -> new RequestLimitWrapper(nextLimitRefreshTime)
        );
        try {
            if(limitWrapper.lock.tryLock()) {
                if(requestReceivedAt>=limitWrapper.getNextLimitRefreshTime()) {
                    limitWrapper.resetRequestCount();
                    limitWrapper.setNextLimitRefreshTime(nextLimitRefreshTime);
                }
                if(limitWrapper.getRequestCount()<this.requestLimit) {
                    limitWrapper.incrementRequestCount();
                    return true;
                }
                return false;
            }
            else return false;
        }
        finally {
            limitWrapper.lock.unlock();
        }
    }

    // // 3. Without lock
    // @Override
    // public boolean isAllowed(Request request) {
    //     String ipAddress = request.getIpAddress();
    //     long requestReceivedAt = System.currentTimeMillis();
    //     long nextLimitRefreshTime = requestReceivedAt + TimeUnit.SECONDS.toMillis(windowSizeInSec);
    //     AtomicReference<AtomicRequestLimitWrapper> ref = requestMap.computeIfAbsent(
    //         ipAddress,
    //         ip -> new AtomicReference<>(new AtomicRequestLimitWrapper(
    //             nextLimitRefreshTime, 0))
    //     );
    //     int retries = 5;
    //     while(retries>0) {
    //         AtomicRequestLimitWrapper currLimitWrapper = ref.get();
    //         AtomicRequestLimitWrapper nextLimitWrapper = null;
    //         if(requestReceivedAt>=currLimitWrapper.getNextLimitRefreshTime()) {
    //             nextLimitWrapper = new AtomicRequestLimitWrapper(
    //                 nextLimitRefreshTime, 1); 
    //         }
    //         else {
    //             if(currLimitWrapper.getRequestCount()<this.requestLimit) {
    //                 nextLimitWrapper = new AtomicRequestLimitWrapper(
    //                     currLimitWrapper.getNextLimitRefreshTime(), 
    //                     currLimitWrapper.getRequestCount()+1);
    //             }
    //             else return false;
    //         }
    //         if(ref.compareAndSet(currLimitWrapper, nextLimitWrapper)) {
    //             return true;
    //         }
    //         retries--;
    //     }
    //     return false;
    // }

    private static class RequestLimitWrapper {
        
        private long nextLimitRefreshTime;
        private long requestCount;
        private final ReentrantLock lock;

        public RequestLimitWrapper(long nextLimitRefreshTime) {
            this.nextLimitRefreshTime = nextLimitRefreshTime;
            this.lock = new ReentrantLock();
        }

        public long getNextLimitRefreshTime() {
            return this.nextLimitRefreshTime;
        }

        public long getRequestCount() {
            return this.requestCount;
        }

        public void setNextLimitRefreshTime(long nextLimitRefreshTime) {
            this.nextLimitRefreshTime = nextLimitRefreshTime;
        }

        public void incrementRequestCount() {
            this.requestCount++;
        }

        public void resetRequestCount() {
            this.requestCount = 0L;
        }
    }

    // private static class AtomicRequestLimitWrapper {
        
    //     private final long nextLimitRefreshTime;
    //     private final long requestCount;

    //     public AtomicRequestLimitWrapper(long nextLimitRefreshTime, long requestCount) {
    //         this.nextLimitRefreshTime = nextLimitRefreshTime;
    //         this.requestCount = requestCount;
    //     }

    //     public long getNextLimitRefreshTime() {
    //         return this.nextLimitRefreshTime;
    //     }

    //     public long getRequestCount() {
    //         return this.requestCount;
    //     }
    // }
}
