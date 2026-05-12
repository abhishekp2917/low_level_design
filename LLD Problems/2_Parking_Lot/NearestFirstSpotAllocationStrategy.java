import java.util.Collection;
import java.util.Optional;

public class NearestFirstSpotAllocationStrategy implements ISpotAllocationStrategy {

    @Override
    public Optional<ParkingSpot> getAvailableSpot(Collection<ParkingSpot> parkingSpots, Vehicle vehicle) {
        return null;
    }
    
}
