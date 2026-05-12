public class SmallParkingSpot extends ParkingSpot {

    public SmallParkingSpot() {
        super();
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        if(vehicle.getVehicleType().equals(VehicleType.SMALL)) return true;
        return false;
    }
    
}
