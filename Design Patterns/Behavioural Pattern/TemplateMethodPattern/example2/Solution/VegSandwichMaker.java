package BehaviouralPattern.TemplateMethodPattern.example2.Solution;

public class VegSandwichMaker extends SandwichMaker {
    
    // overriding method to add vegies only as main ingredient
    @Override
    public void addMainIngredient() {
        System.out.println("Adding chopped onion, tomato and silantro");
    }

    // overriding method to add peanut butter as a sauce instead to tomato sauce
    @Override
    public void addSauce() {
        System.out.println("Adding peanut butter");
    }
}
