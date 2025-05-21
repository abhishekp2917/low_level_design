package StructuralPattern.CompositePattern.example1;

import java.util.ArrayList;
import java.util.List;


/* 
    composite class implements Component interface since all the composites are
    some kind of components

    composite components are collection of components, hence it has a list of 
    components as an attribute
*/
public class Composite extends Component{

    private String name;
    private List <Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Component> getComponents() {
        return this.components;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    public void removeComponent(Component component) {
        this.components.remove(component);
    }

    /* 
        overriding cacculatePrice of component interface since all the components
        are have same task to perform with different way of implementation
    */
    @Override
    public double calculatePrice() {
        double tempPrice = 0;

        for(Component c : components) {
            tempPrice += c.calculatePrice();
        }

        return tempPrice;
    }
}
