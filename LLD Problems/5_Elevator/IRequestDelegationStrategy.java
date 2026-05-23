import java.util.Collection;
import java.util.Optional;

public interface IRequestDelegationStrategy {
    
    public Optional<Long> delegateRequest(int floorNumber, Direction direction, Collection<ElevatorContext> elevators);
}
