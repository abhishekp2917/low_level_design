// NullVehicle implements the Vehicle interface and provides default implementations
// This class is part of the Null Object Pattern to avoid null checks in client code
public class NullVehicle implements Vehicle {

    // Default behavior for drive() when a real Vehicle is not available
    @Override
    public void drive() {
        System.out.println("Default drive implementation.");
    }

    // Default behavior for park() when a real Vehicle is not available
    @Override
    public void park() {
        System.out.println("Default park implementation.");
    }
}
