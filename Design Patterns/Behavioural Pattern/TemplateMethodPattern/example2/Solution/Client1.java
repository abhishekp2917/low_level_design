package BehaviouralPattern.TemplateMethodPattern.example2.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating veg sandwich maker 
        SandwichMaker maker1 = new VegSandwichMaker();

        // creating chicken sandwich maker
        SandwichMaker maker2 = new ChickenSandwichMaker();

        // making sandwich using veg sandwich maker
        maker1.makeSandwich();

        System.out.println();

        // making sandwich using chicken sandwich maker
        maker2.makeSandwich();
    }
}
