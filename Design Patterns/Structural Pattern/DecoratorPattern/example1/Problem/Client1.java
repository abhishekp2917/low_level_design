package StructuralPattern.DecoratorPattern.example1.Problem;

public class Client1 {
    
    public static void main(String[] args) {

        /*  creating objects of various combination of Dishes and Addons
            which is not feasible as we have to make all the combinations of classes
            based on Dishes and Addons
        */
        
        // creating Dosha dish with Sambhar as addons 
        Dishes sambharDosha = new SambharDosha(2, 60, 20);

        // creating Samosha dish with Ketchup as addons 
        Dishes ketchupSamosha = new KetchupSamosha(4, 10, 10);

        // creating Dosha dish with Ketchup and Sambhar as addons
        Dishes ketchupSambharDosha = new KetchupSambharDosha(2, 60, 10, 20);


        sambharDosha.description();
        System.out.println("Dosha with Sambhar total cost : " + sambharDosha.calculateCost());

        System.out.println();

        ketchupSamosha.description();
        System.out.println("Samosha with Ketchup total cost : " + ketchupSamosha.calculateCost());

        System.out.println();

        ketchupSambharDosha.description();
        System.out.println("Samosha with Ketchup and Sambhar total cost  : " + ketchupSambharDosha.calculateCost());
    }
}
