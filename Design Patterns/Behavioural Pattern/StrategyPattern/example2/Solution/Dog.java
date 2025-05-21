package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    Dog which is an animal and breath from lungs and thus uses BreathFromLungs 
    object to perform breathing
*/
public class Dog extends Animal {

    private final Breath breath;

    public Dog(String name, Breath breath) {
        super(name);
        this.breath = breath;
    }

    @Override
    public void breath() {
        System.out.println("Dog named " + this.name + " " + breath.perform());    
    }
}
