import java.util.Collection;
import java.util.Optional;

public interface ISpotAllocationStrategy {
    
    public Optional<ParkingSpot> getAvailableSpot(Collection<ParkingSpot> parkingSpots, Vehicle vehicle);
}
