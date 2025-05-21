package CreationalPattern.FactoryPattern.example1;


/*  
    creating factory class form Animals to create Animal child class objects
    In this way factory pattern will be implemented
    
*/
public class AnimalFactory {
    
    public Animal getAnimal(String animalName) {

        if(animalName=="Cow") {

            return new Cow();
        }
        else if(animalName=="Cat") {

            return new Cat();
        }
        else {
            
            return new Dog();
        }
    }
}
