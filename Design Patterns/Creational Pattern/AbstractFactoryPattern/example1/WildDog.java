package CreationalPattern.AbstractFactoryPattern.example1;

public class WildDog extends Dog {

    @Override
    public void eat() { 
        System.out.println("Eats cat and flesh");
    }

    public void hunt() {
        System.out.println("Hunt and kill cat and other small animals");
    }

    @Override
    public String toString() {
        return "[Wild dog eats cat and hunts]";
    }
}

