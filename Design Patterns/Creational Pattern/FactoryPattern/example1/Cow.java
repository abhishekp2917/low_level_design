package CreationalPattern.FactoryPattern.example1;

public class Cow implements Animal {

    // overriding live method of interface Animal
    @Override
    public void live() {
        
        System.out.println("Cow lives in a group");
    }


    // overriding speak method of interface Animal
    @Override
    public void speak() {
       
       System.out.println("Moo Moo"); 
    }
}
