package CreationalPattern.AbstractFactoryPattern.example1;

public abstract class Dog implements Animal {

    @Override
    public void speak() {
       System.out.println("Bhau Bhau"); 
    }

    @Override
    public abstract void eat();
}
