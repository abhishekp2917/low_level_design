package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    abstract Animal class where each animal has breath functionality and some 
    animals breath differently 
*/
public abstract class Animal {
    
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    // method to eat food
    public void eat() {
        System.out.println("Eating food");
    }

    // abstract method to breath
    public abstract void breath();
}
