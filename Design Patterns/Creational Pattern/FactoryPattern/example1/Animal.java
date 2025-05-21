package CreationalPattern.FactoryPattern.example1;


// creating an interface name 'Animal'
public interface Animal {
    
    // interface variables are public stativ final by default
    int LEG = 4;
    
    /*  interface methods whose implementation must be provided by non abstract 
        child class 
    */
    public void live();
    public void speak();
}
