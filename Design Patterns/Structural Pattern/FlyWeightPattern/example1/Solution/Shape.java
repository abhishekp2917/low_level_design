// The Flyweight interface which defines the operation(s) 
// that all concrete flyweight objects must implement.
public interface Shape {

    // Method to draw the shape.
    void draw();

    void setPosition(double xCoordinate, double yCoordinate);
}
