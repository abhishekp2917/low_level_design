import java.util.concurrent.atomic.AtomicLong;

public abstract class ParkingSpot {
    
    private static final AtomicLong incrementer = new AtomicLong();
    private final long id;
    private volatile Vehicle occupiedVehicle;

    public ParkingSpot() {
        this.id = generateId();
    }

    public long getId() { return this.id; }

    public Vehicle getOccupiedVehicle() { return this.occupiedVehicle; }

    public boolean isAvailable() {
        return this.occupiedVehicle==null;
    }

    public abstract boolean canFit(Vehicle vehicle);

    public synchronized boolean tryPark(Vehicle vehicle) {
        if(!isAvailable() || !canFit(vehicle)) {
            return false;
        }
        this.occupiedVehicle = vehicle;
        return true;
    }

    public synchronized boolean tryUnpark() {
        if(isAvailable()) {
            return false;
        }
        this.occupiedVehicle = null;
        return true;
    }

    private static long generateId() {
        return incrementer.incrementAndGet();
    }
}
