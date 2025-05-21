package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    Cat which is an animal and breath from lungs and thus uses BreathFromLungs 
    object to perform breathing
*/
public class Cat extends Animal {

    private final Breath breath;

    public Cat(String name, Breath breath) {
        super(name);
        this.breath = breath;
    }
    
    @Override
    public void breath() {
        System.out.println("Cat named " + this.name + " " + breath.perform());
    }
}
