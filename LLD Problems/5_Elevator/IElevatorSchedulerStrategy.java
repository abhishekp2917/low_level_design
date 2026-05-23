import java.util.Collection;
import java.util.Optional;

public interface IElevatorSchedulerStrategy {

    public void addFloor(int floor);
        
    public Optional<Integer> getNextFloor(ElevatorContext context);

    public Collection<Integer> getRequests();

    public void removeFloor(int floor);

    public boolean isEmpty();
}
