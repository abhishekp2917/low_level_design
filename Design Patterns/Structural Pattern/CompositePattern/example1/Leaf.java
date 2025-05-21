package StructuralPattern.CompositePattern.example1;


/* 
    leaf class implements Component interface since all the leaf (single entity) are
    some kind of components

    leaf component is a single entity and hence it has only price and not list of
    components similar to composite class
*/
public class Leaf extends Component{

    private String name;
    private double price;

    public Leaf(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /* 
        overriding cacculatePrice of component interface since all the components
        are have same task to perform with different way of implementation
    */
    @Override
    public double calculatePrice() {
        return this.price;
    }
}
