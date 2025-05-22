public class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving Car...");
    }

    @Override
    public void park() {
        System.out.println("Car parked successfully.");
    }
    
}
