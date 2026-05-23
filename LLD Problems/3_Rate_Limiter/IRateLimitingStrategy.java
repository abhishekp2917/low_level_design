public interface IRateLimitingStrategy {
    
    public boolean isAllowed(ElevatorContext request);
}
