package CreationalPattern.FactoryPattern.example1;

public class Cat implements Animal {

    // overriding live method of interface Animal
    @Override
    public void live() {
        
        System.out.println("Cat lives alone");
    }


    // overriding speak method of interface Animal
    @Override
    public void speak() {
       
       System.out.println("Meow Meow"); 
    }
    
}
