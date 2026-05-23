public class RateLimiter {
    
    private final RateLimitingStrategyFactory rateLimitingStrategyFactory;

    public RateLimiter() {
        this.rateLimitingStrategyFactory = new RateLimitingStrategyFactory();
    }

    public void setRateLimitingStrategy(IRateLimitingConfig<? extends IRateLimitingStrategy> rateLimitingConfig) {
        this.rateLimitingStrategyFactory.setRateLimitingConfig(rateLimitingConfig);
    }

    public boolean isAllowed(ElevatorContext request) {
        return rateLimitingStrategyFactory.getInstance().isAllowed(request);
    }

}
