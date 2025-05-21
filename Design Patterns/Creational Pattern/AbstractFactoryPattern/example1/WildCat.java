package CreationalPattern.AbstractFactoryPattern.example1;

public class WildCat extends Cat{

    @Override
    public void eat() {
        System.out.println("Eats mouse and flesh");        
    }

    public void hunt(){
        System.out.println("Hunt and kill other small animals");
    }

    @Override
    public String toString() {
        return "[Wild cat eats mouse and hunts]";
    }
}
