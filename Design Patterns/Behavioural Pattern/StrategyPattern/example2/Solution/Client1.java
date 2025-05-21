package BehaviouralPattern.StrategyPattern.example2.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating various animals having diffirent breathing methods
        Cat cat1 = new Cat("Zach", new BreathFromLungs());
        Dog dog1 = new Dog("Beck", new BreathFromLungs());
        Parrot parrot1 = new Parrot("Metthu", new BreathFromLungs());
        Piegon piegon1 = new Piegon("Chanu", new BreathFromLungs());
        Fish fish1 = new Fish("sunny", new BreathFromGills());
        Frog frog1 = new Frog("tricksy", new BreathFromLungs(), true);

        // implementing breathing functionality of all aniamls
        cat1.breath();
        dog1.breath();
        parrot1.breath();
        piegon1.breath();
        fish1.breath();
        frog1.breath();

        // changing position of frog from land to water
        frog1.setOnLand(false);

        // frog breathing inside water
        frog1.breath();
    }
}
