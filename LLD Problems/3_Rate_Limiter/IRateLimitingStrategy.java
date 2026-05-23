public interface IRateLimitingStrategy {
    
    public boolean isAllowed(Request request);
}
