package CreationalPattern.FactoryPattern.example1;


public class Client1 {

    public static void main(String[] args){

        // creating AnimalFactory object to create animal type objects
        AnimalFactory factory = new AnimalFactory();

        // creating various animal objects usinf factory object
        Animal cow1 = factory.getAnimal("Cow");
        
        Animal cat1 = factory.getAnimal("Cat");

        Animal dog1 = factory.getAnimal("Dog");

        // invoking various animal objects method
        cow1.speak();
        cat1.speak();
        dog1.speak();
    }
    
}
