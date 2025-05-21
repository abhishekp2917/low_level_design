// Factory class to create Vehicle objects based on input type
public class VehicleFactory {

    // Method to return a Vehicle instance based on the vehicleType string
    public Vehicle getVehicle(String vehicleType) {

        // Check the value of vehicleType and return the appropriate Vehicle subclass
        switch (vehicleType) {
            case "Car": {
                // If type is "Car", return a new instance of Car
                return new Car();
            }
            case "Truck": {
                // If type is "Truck", return a new instance of Truck
                return new Truck();
            }
            default: {
                // If no matching type is found, return a NullVehicle instance instead of null (Null Object Pattern)
                // this would eliminate the neccessity for null checks in client code
                return new NullVehicle();
            }
        }
    }
}
