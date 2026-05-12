import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ParkingManager {

    private final ConcurrentMap<Long, ParkingFloor> parkingFloors;
    private final ConcurrentMap<Long, Ticket> tickets;
    private IPricingStrategy pricingStrategy;
    private IFloorAllocationStrategy floorAllocationStrategy;

    public ParkingManager(IPricingStrategy pricingStrategy, IFloorAllocationStrategy floorAllocationStrategy) {
        this.parkingFloors = new ConcurrentHashMap<>();
        this.tickets = new ConcurrentHashMap<>();
        this.pricingStrategy = pricingStrategy;
        this.floorAllocationStrategy = floorAllocationStrategy;
    }

    public void createParkingFloor(ISpotAllocationStrategy parkingStrategy) {
        ParkingFloor parkingFloor = new ParkingFloor(parkingStrategy);
        this.parkingFloors.put(parkingFloor.getId(), parkingFloor);
    }

    public void createParkingSpot(long parkingFloorId, SpotType spotType) {
        if(!parkingFloors.containsKey(parkingFloorId)) {
            throw new IllegalArgumentException("Invalid parking floor.");
        }
        this.parkingFloors.get(parkingFloorId).createParkingSpot(spotType);
    }

    public List<Long> getParkingFloors() {
        return this.parkingFloors.keySet().stream().toList();
    }

    public Ticket park(String vin, String ownerName, VehicleType vehicleType) {
        if(vin==null || vin.trim().isBlank()) {
            throw new IllegalArgumentException("VIN is required to park vehle");
        }
        if(ownerName==null || ownerName.trim().isBlank()) {
            throw new IllegalArgumentException("Owner Name is required to park vehle");
        }
        Vehicle vehicle = new Vehicle(vin, ownerName, vehicleType);
        while(true) {
            Optional<ParkingFloor> availableParkingFloor = this.floorAllocationStrategy.getAvailableFloor(
                this.parkingFloors.values(), vehicle);
            if(availableParkingFloor.isEmpty()) {
                throw new IllegalStateException("No parking floor is available.");
            }
            ParkingFloor parkingFloor = availableParkingFloor.get(); 
            ParkingSpot parkingSpot = parkingFloor.allocateSpot(vehicle);
            Ticket ticket = new Ticket(parkingSpot, vehicle);
            this.tickets.put(ticket.getId(), ticket);
            return ticket;
        }
    }

    public double checkout(long ticketId) {
        if(!this.tickets.containsKey(ticketId)) {
            throw new IllegalArgumentException("Invalid ticket.");
        }
        Ticket ticket = this.tickets.get(ticketId);
        ticket.closeTicket();
        ticket.getParkingSpot().tryUnpark();
        double price = this.pricingStrategy.calculatePrice(ticket);
        return price;
    }
}