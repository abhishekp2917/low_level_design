package StructuralPattern.DecoratorPattern.example1.Solution;

public class Sambhar extends Addons{

    public Sambhar(double addonCost, Dishes dish) {
        super(addonCost, dish);
    }

    @Override
    public void description() {
        this.dish.description();
        System.out.println("Sambhar : cost = " + this.addonCost);
    }

    @Override
    public double calculateCost() {
        return this.dish.calculateCost() + this.addonCost;
    }
}
