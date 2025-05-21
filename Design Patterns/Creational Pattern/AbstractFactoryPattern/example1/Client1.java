package CreationalPattern.AbstractFactoryPattern.example1;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating wildFactory object using abstract factory method
        Factory wildFactory = FactoryCreator.createFactory("wild");

        // creating petFactory object using abstract factory method
        Factory petFactory = FactoryCreator.createFactory("pet");

        // creating wild dog object using wildFactory
        Animal wildDog1 = wildFactory.getAnimal("dog");

        // creating pet cat object using petFactory
        Animal petCat1 = petFactory.getAnimal("cat");

        // printing wild dog and pet cat object
        System.out.println(wildDog1);

        System.out.println(petCat1);



    }
}
