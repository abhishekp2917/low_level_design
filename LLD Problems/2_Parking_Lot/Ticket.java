import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Ticket {
    
    private static final AtomicLong incrementer = new AtomicLong();
    private final long id;
    private final LocalDateTime entryTime;
    private volatile LocalDateTime exitTime;
    private final ParkingSpot parkingSpot;
    private final Vehicle vehicle;
    
    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.id = generateId();
        this.entryTime = LocalDateTime.now();
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    } 

    public long getId() { return this.id; }

    public LocalDateTime getEntryTime() { return this.entryTime; }

    public LocalDateTime getExitTime() { 
        if(this.exitTime==null) {
            throw new IllegalStateException("Ticket is not closed yet.");
        }
        return this.exitTime;
    }

    public ParkingSpot getParkingSpot() { return this.parkingSpot; }

    public Vehicle getVehicle() { return this.vehicle; }

    public synchronized void closeTicket() {
        if(this.exitTime!=null) {
            throw new IllegalStateException("Ticket is already closed.");
        }
        this.exitTime = LocalDateTime.now();
    }

    private static long generateId() {
        return incrementer.incrementAndGet();
    }
}
