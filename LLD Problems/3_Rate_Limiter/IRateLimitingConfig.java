public interface IRateLimitingConfig<T extends IRateLimitingStrategy> {
    
    public T createStrategy();
}
