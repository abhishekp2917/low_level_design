package StructuralPattern.DecoratorPattern.example1.Problem;


public class Samosha extends Dishes{

    public Samosha(int quantity, double cost) {
        super(quantity, cost);
    }

    /* 
        overriding description method where each dishes can have there own 
        implemetation for this method
    */
    @Override
    public void description() {
        System.out.println("Dish description : ");
        System.out.println("Name : Samosha");
        System.out.println("Quantity : " + this.quantity);
        System.out.println("Per plate cost = " + this.cost);
    }

    /* 
        overriding description method where each dishes can have there own 
        way of calculating cost for this method
    */
    @Override
    public double calculateCost() {
        return this.cost*this.quantity;
    }
}
