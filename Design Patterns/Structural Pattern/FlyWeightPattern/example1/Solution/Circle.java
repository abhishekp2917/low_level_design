/*
 * Circle class represents the "Flyweight" object in the Flyweight Design Pattern.
 *
 * In this solution, we aim to reduce memory usage by sharing Circle objects that have the same intrinsic state.
 * 
 * INTRINSIC STATE: Stored within the object and shared. Should be immutable and independent of the context.
 *    - radius
 *    - color
 *
 * EXTRINSIC STATE: Supplied by the client at runtime. Varies between object uses.
 *    - xCoordinate
 *    - yCoordinate
 */
public class Circle implements Shape {

    // Intrinsic data (shared state): does not change per use and can be cached
    private double radius;
    private Color color;

    // Extrinsic data (unique per operation): passed/set per call, not stored for sharing
    private double xCoordinate;
    private double yCoordinate;

    /*
     * Constructor initializes intrinsic data.
     * In Flyweight pattern, this should ideally be done only once per unique combination.
     */
    public Circle(double radius, Color color) {
        this.radius = radius;
        this.color = color;
        System.out.println("Circle object created");
    }

    /*
     * This method is used to supply the extrinsic state to the object before it is used.
     * These values are not considered part of the identity of the Circle object.
     */
    public void setPosition(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /*
     * Simulates drawing the circle with its intrinsic and extrinsic properties.
     * Note that intrinsic properties are shared, but extrinsic ones vary.
     */
    public void draw() {
        System.out.println("Drawing Circle:");
        System.out.println("Radius = " + this.radius);              // intrinsic
        System.out.println("X Co-ordinate = " + this.xCoordinate);  // extrinsic
        System.out.println("Y Co-ordinate = " + this.yCoordinate);  // extrinsic
        System.out.println("Color = " + this.color);                // intrinsic
    }
}
