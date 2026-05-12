public class MediumParkingSpot extends ParkingSpot {

    public MediumParkingSpot() {
        super();
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        if(
            vehicle.getVehicleType().equals(VehicleType.SMALL) ||
            vehicle.getVehicleType().equals(VehicleType.MEDIUM) ) return true;
        return false;
    }
    
}
