package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    Piegon which is an animal and breath from lungs and thus uses BreathFromLungs 
    object to perform breathing
*/
public class Piegon extends Animal {

    private final Breath breath;

    public Piegon(String name, Breath breath) {
        super(name);
        this.breath = breath;
    }

    @Override
    public void breath() {
        System.out.println("Piegon named " + this.name + " " + breath.perform());
    }
}
