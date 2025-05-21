package CreationalPattern.AbstractFactoryPattern.example1;

public class PetDog extends Dog{
    
    @Override
    public void eat() {
        System.out.println("Eats dog food");
    }

    public void play() {
        System.out.println("Plays with stick");
    }

    @Override
    public String toString() {
        return "[Pet dog eats dog food and plays with stick]";
    }
}
