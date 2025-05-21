package CreationalPattern.AbstractFactoryPattern.example1;

public class FactoryCreator {
    
    public static Factory createFactory(String factoryType) {

        if(factoryType=="wild") {
            return new WildFactory();
        }
        else if(factoryType=="Pet") {
            return new PetFactory();
        }
        else {
            return new PetFactory(); 
        }
    }
}
