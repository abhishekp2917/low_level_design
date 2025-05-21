package StructuralPattern.DecoratorPattern.example1.Problem;


/* 
  creating class for Dosha dish with Ketchup and Sambhar as an addons 
*/
public class KetchupSambharDosha extends Dishes{

    private double ketuchupCost;
    private double sambharCost;

    public KetchupSambharDosha(int quantity, double cost, double ketuchupCost, double sambharCost) {
        super(quantity, cost);
        this.ketuchupCost = ketuchupCost;
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
        System.out.println("Ketchup : cost = " + this.ketuchupCost);
        System.out.println("Sambhar : cost = " + this.sambharCost);
    }

    /* 
        overriding description method where each dishes can have there own 
        way of calculating cost for this method
    */
    @Override
    public double calculateCost() {
        return this.cost*this.quantity + this.ketuchupCost + this.sambharCost;
    }
}
