package StructuralPattern.CompositePattern.example1;

import java.util.List;

/*  
    all the leaf and composite in this composite pattern is of type 
    all the components must have same methods or task to perform

    in this case calculating price of the component is main objective (task)
*/
public abstract class Component {

    public abstract String getName();

    public abstract double calculatePrice();
}
