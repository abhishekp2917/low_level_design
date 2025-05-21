package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    frog which is an amphibian and can breath from lungs on land and skin in water
*/
public class Frog extends Animal{

    private Breath breath;
    private boolean onLand;

    public Frog(String name, Breath breath, boolean onLand) {
        super(name);
        this.breath = breath;
        this.onLand = onLand;
    }

    // method to change current place of frog whether it is onland or in water
    public void setOnLand(boolean onLand) {
        this.onLand = onLand;
    }

    // override breath method
    @Override
    public void breath() {

        // breath from lungs on land
        if(onLand) {
            breath = new BreathFromLungs();
            System.out.println("Frog named " + this.name + " " + breath.perform());
        }
        // breath from skin in water
        else {
            breath = new BreathFromSkin();
            System.out.println("Frog named " + this.name + " " + breath.perform());
        }
    }
}
