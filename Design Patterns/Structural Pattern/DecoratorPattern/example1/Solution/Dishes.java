package StructuralPattern.DecoratorPattern.example1.Solution;

/*
    creating 'Dishes' abstract class from which various concrete dishes and addons 
    will be inherited 
*/
public abstract class Dishes {

    protected int quantity;
    protected double cost;

    public Dishes(int quantity, double cost) {
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /* 
        abstract methods whose implementation will be provided by concrete classes
    */
    public abstract void description();
    public abstract double calculateCost();
}