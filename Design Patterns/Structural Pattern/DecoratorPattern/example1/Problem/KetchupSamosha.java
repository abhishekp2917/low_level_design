package StructuralPattern.DecoratorPattern.example1.Problem;


/* 
  creating class for Samosha dish with Ketchup as an addons 
*/
public class KetchupSamosha extends Dishes{

    private double ketuchupCost;
    public KetchupSamosha(int quantity, double cost, double ketuchupCost) {
        super(quantity, cost);
        this.ketuchupCost = ketuchupCost;
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
    }

    /* 
        overriding description method where each dishes can have there own 
        way of calculating cost for this method
    */
    @Override
    public double calculateCost() {
        return this.cost*this.quantity + this.ketuchupCost;
    }
}
