package StructuralPattern.DecoratorPattern.example1.Solution;

public abstract class Addons extends Dishes{

    /* 
        using Dishes class object to add various addons to that partiular dish
        and perform same function that Dishes class performs 
    */
    protected Dishes dish;
    protected double addonCost;

    public Addons(double addonCost, Dishes dish) {
        super(dish.quantity, dish.cost);
        this.dish = dish;
        this.addonCost = addonCost;
    }

    public Dishes getDish() {
        return dish;
    }

    public double getAddonCost() {
        return addonCost;
    }

    public void setDish(Dishes dish) {
        this.dish = dish;
    }

    public void setAddonCost(double addonCost) {
        this.addonCost = addonCost;
    }   
}
