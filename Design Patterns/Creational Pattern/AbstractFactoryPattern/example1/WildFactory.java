package CreationalPattern.AbstractFactoryPattern.example1;

public class WildFactory implements Factory{
    
    public Animal getAnimal(String animalName) {

        if(animalName=="Dog") {
            return new WildDog();
        }
        else if(animalName=="Cat") {
            return new WildCat();
        }
        else {
            return new WildDog();
        }
    }
}
