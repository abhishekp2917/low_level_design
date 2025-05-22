public class Client1 {
    
    public static void main(String[] args) {
        
        // factory class to get Vehicle object
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle vehicle1 = vehicleFactory.getVehicle("Car");
        Vehicle vehicle2 = vehicleFactory.getVehicle("Truck");

        // since there is no vehicle of type 'Bike', VehicleFactory will return 'Vehicle' object -> 'NullVehicle' instead of returning 'null';
        Vehicle vehicle3 = vehicleFactory.getVehicle("Bike");

        vehicle1.drive();
        vehicle1.park();

        vehicle2.drive();
        vehicle2.park();

        // this will not throw null pointer exception as 'vehicle3' is not null but of type 'NullVehicle'
        // we don't need to encapsulate this statement under a if condition to check if the obejct is not null  
        vehicle3.drive();
        vehicle3.park();
    }
}
