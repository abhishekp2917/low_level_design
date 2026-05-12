import java.util.concurrent.atomic.AtomicLong;

public class Vehicle {
 
    private static final AtomicLong incrementer = new AtomicLong();
    private final long id;
    private final String vin;
    private final String ownerName;
    private final VehicleType vehicleType;

    public Vehicle(String vin, String ownerName, VehicleType vehicleType) {
        this.id = generateId();
        this.vin = vin;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() { return this.vehicleType; }

    private static long generateId() {
        return incrementer.incrementAndGet();
    }
}
