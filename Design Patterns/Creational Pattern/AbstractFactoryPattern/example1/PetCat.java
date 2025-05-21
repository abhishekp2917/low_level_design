package CreationalPattern.AbstractFactoryPattern.example1;

public class PetCat extends Cat{

    @Override
    public void eat() {
        System.out.println("Eats cat food");
    }

    public void play() {
        System.out.println("Plays with ball");
    }

    @Override
    public String toString() {
        return "[Pet cat eats cat food and plays with ball]";
    }
}
