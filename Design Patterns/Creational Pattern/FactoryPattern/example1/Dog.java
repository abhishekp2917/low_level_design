package CreationalPattern.FactoryPattern.example1;

public class Dog implements Animal {

    // overriding live method of interface Animal
    @Override
    public void live() {
        
        System.out.println("Dog lives in a group");   
    }

    // overriding speak method of interface Animal
    @Override
    public void speak() {
        
        System.out.println("Bau Bhau");    
    }
    
}
