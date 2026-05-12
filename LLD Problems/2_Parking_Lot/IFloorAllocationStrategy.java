import java.util.Collection;
import java.util.Optional;

public interface IFloorAllocationStrategy {
    
    public Optional<ParkingFloor> getAvailableFloor(Collection<ParkingFloor> parkingfloors, Vehicle vehicle);
}
