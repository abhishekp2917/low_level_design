package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    Parrot which is an animal and breath from lungs and thus uses BreathFromLungs 
    object to perform breathing
*/
public class Parrot extends Animal {

    private final Breath breath;

    public Parrot(String name, Breath breath) {
        super(name);
        this.breath = breath;
    }

    @Override
    public void breath() {
        System.out.println("Parrot named " + this.name + " " + breath.perform());
    }
}
