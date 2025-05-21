package CreationalPattern.AbstractFactoryPattern.example1;

public interface Animal {
    
    // interface sttributes are public, static and final by default 
    int EARS = 2;
    boolean hasTail = true;
    
    // interface methods are public and abstract by default
    public void speak();
    public void eat(); 
}
