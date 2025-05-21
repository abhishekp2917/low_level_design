package StructuralPattern.DecoratorPattern.example1.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating Dosha dish with Sambhar as addons 
        Dishes sambharDosha = new Sambhar(20, new Dosha(2, 60));

        // creating Samosha dish with Ketchup as addons 
        Dishes ketchupSamosha = new Ketchup(10,  new Samosha(4, 10));

        // creating Samosha dish with Ketchup and Sambhar as addons
        Dishes ketchupSambharSamosha = new Sambhar(20, ketchupSamosha);


        sambharDosha.description();
        System.out.println("Dosha with Sambhar total cost : " + sambharDosha.calculateCost());

        System.out.println();

        ketchupSamosha.description();
        System.out.println("Samosha with Ketchup total cost : " + ketchupSamosha.calculateCost());

        System.out.println();

        ketchupSambharSamosha.description();
        System.out.println("Samosha with Ketchup and Sambhar total cost  : " + ketchupSambharSamosha.calculateCost());
    }
}
