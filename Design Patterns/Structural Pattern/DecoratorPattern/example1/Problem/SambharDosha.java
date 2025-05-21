package StructuralPattern.DecoratorPattern.example1.Problem;

/* 
  creating class for Dosha dish with Sambhar as an addons 
*/
public class SambharDosha extends Dishes{

    private double sambharCost;

    public SambharDosha(int quantity, double cost, double sambharCost) {
        super(quantity, cost);
        this.sambharCost = sambharCost;
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
        System.out.println("Sambhar : cost = " + this.sambharCost);
    }

    /* 
        overriding description method where each dishes can have there own 
        way of calculating cost for this method
    */
    @Override
    public double calculateCost() {
        return this.cost*this.quantity + this.sambharCost;
    }
}
