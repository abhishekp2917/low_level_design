package CreationalPattern.AbstractFactoryPattern.example1;

public abstract class Cat implements Animal {

    @Override
    public void speak() {
        System.out.println("Meow Meow");
    }

    @Override
    public abstract void eat();
}
