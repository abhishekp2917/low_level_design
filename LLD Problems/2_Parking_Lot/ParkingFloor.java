import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class ParkingFloor {
    
    private static final AtomicLong incrementer = new AtomicLong();
    private final long id;
    private final ConcurrentMap<Long, ParkingSpot> parkingSpots;
    private ISpotAllocationStrategy spotAllocationStrategy;
    private final int MAX_ATTEMPTS;

    public ParkingFloor(ISpotAllocationStrategy spotAllocationStrategy) {
        this.id = generateId();
        this.parkingSpots = new ConcurrentHashMap<>();
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.MAX_ATTEMPTS = 5;
    }

    public long getId() { return this.id; }

    public ParkingSpot allocateSpot(Vehicle vehicle) {
        int attempts = this.MAX_ATTEMPTS;
        while(attempts>0) {
            Optional<ParkingSpot> availableParkingSpot = this.spotAllocationStrategy.getAvailableSpot(
                this.parkingSpots.values(), 
                vehicle);
            if(availableParkingSpot.isEmpty()) {
                throw new IllegalStateException("No parking spot available.");
            }
            ParkingSpot parkingSpot = availableParkingSpot.get();
            if(parkingSpot.tryPark(vehicle)) {   
                return parkingSpot;
            }
            attempts--;
            try {
                Thread.sleep(1);
            }
            catch(InterruptedException e) { 
                Thread.currentThread().interrupt();
            }
        }
        throw new IllegalStateException("Maximum attempt reached. Please try again later.");
    }  

    public void createParkingSpot(SpotType spotType) {
        ParkingSpot parkingSpot = ParkingSpotFactory.get(spotType);
        this.parkingSpots.put(parkingSpot.getId(), parkingSpot);
    }

    private static long generateId() {
        return incrementer.incrementAndGet();
    }
}
