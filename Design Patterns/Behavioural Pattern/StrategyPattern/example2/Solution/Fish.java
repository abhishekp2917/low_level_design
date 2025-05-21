package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    Fish which is an animal and breath from gills and thus uses BreathFromGills 
    object to perform breathing
*/
public class Fish extends Animal {

    private final Breath breath;

    public Fish(String name, Breath breath) {
        super(name);
        this.breath = breath;
    }

    @Override
    public void breath() {
        System.out.println("Fish named " + this.name + " " + breath.perform());
    }
}
