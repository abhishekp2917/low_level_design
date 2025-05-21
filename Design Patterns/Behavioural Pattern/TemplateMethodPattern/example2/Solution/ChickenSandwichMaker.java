package BehaviouralPattern.TemplateMethodPattern.example2.Solution;

public class ChickenSandwichMaker extends SandwichMaker {
    
    // overriding method to add chopped chicken only as main ingredient
    @Override
    public void addMainIngredient() {
        System.out.println("Adding chopped chicken");
    }

    // overriding method to add pineapple toping instead to pomegrante toping
    @Override
    public void addTopings() {
        System.out.println("Adding pineapple toping");
    }

    // overriding method to add tomato ketchup instead of tomato sauce
    @Override
    public void addSauce() {
        System.out.println("Adding tomato ketchup");
    }
}
