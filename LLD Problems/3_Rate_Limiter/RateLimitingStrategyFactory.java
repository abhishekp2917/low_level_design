public class RateLimitingStrategyFactory {
    
    private volatile IRateLimitingConfig<? extends IRateLimitingStrategy> config;
    private volatile IRateLimitingStrategy rateLimitingStrategy;

    public void setRateLimitingConfig(IRateLimitingConfig<? extends IRateLimitingStrategy> config) {
        this.rateLimitingStrategy = config.createStrategy();
        this.config = config;
    }

    public IRateLimitingStrategy getInstance() {
        IRateLimitingStrategy rateLimitingStrategy = this.rateLimitingStrategy;
        if(rateLimitingStrategy==null) {
            throw new IllegalStateException("No Rate Limiting Strategy set.");
        }
        return rateLimitingStrategy;
    }
}
