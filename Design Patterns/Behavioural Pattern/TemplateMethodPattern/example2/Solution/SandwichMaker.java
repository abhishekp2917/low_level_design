package BehaviouralPattern.TemplateMethodPattern.example2.Solution;

/* 
    SandwichMaker class to make sandwich by doing various process 
*/
public class SandwichMaker {
    
    // method to select bread
    public void selectBread() {
        System.out.println("Selecting large bread");
    }

    // method to add main ingredient
    public void addMainIngredient() {
        System.out.println("Adding meat and vegies");
    }

    // method to add topings
    public void addTopings() {
        System.out.println("Adding pomegranate toping");
    }

    // method to add sauce
    public void addSauce() {
        System.out.println("Adding tomato sauce");
    }

    // method to bake sandwich
    public void bakeSandwich() {
        System.out.println("Baking sandwich");
    }

    // template method to make sandwich
    public void makeSandwich() {
        this.selectBread();
        this.addMainIngredient();
        this.addTopings();
        this.addSauce();
        this.bakeSandwich();
    }
}
