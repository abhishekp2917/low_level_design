public class Truck implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving Truck...");
    }

    @Override
    public void park() {
        System.out.println("Truck parked successfully.");
    }
}
