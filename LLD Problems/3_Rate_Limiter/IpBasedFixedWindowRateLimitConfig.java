public class IpBasedFixedWindowRateLimitConfig implements IRateLimitingConfig<IpBasedFixedWindowRateLimitingStrategy> {
    
    private final long requestLimit;
    private final long windowSizeInSec;

    public IpBasedFixedWindowRateLimitConfig(long requestLimit, long windowSizeInSec) {
        this.requestLimit = requestLimit;
        this.windowSizeInSec = windowSizeInSec;
    }

    @Override
    public IpBasedFixedWindowRateLimitingStrategy createStrategy() {
        return new IpBasedFixedWindowRateLimitingStrategy(requestLimit, windowSizeInSec);
    }    
}

    
