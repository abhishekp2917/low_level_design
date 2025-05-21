package CreationalPattern.AbstractFactoryPattern.example1;

public class PetFactory implements Factory{
    
    public Animal getAnimal(String animalName) {

        if(animalName=="dog") {
            return new PetDog();
        }
        else if(animalName=="cat") {
            return new PetCat();
        }
        else {
            return new PetDog();
        }
    }
}
