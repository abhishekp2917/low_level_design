package StructuralPattern.DecoratorPattern.example1.Solution;

public class Ketchup extends Addons{
    
    public Ketchup(double addonCost, Dishes dish) {
        super(addonCost, dish);
    }

    /* 
        overriding descrption method and modifying it based on addons selected
        by customer
    */
    @Override
    public void description() {
        this.dish.description();
        System.out.println("Ketchup : cost = " + this.addonCost);
    }

    /* 
        overriding calculateCost method and modifying it based on addons selected
        by customer
    */
    @Override
    public double calculateCost() {
        return this.dish.calculateCost() + this.addonCost;
    }
}
