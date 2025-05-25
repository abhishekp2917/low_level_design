/* 
    Circle class whose lots of objects is to created
*/
public class Circle implements Shape {

    private double radius;
    private Color color;
    private double xCoordinate;
    private double yCoordinate;
    

    public Circle(double radius, Color color) {
        this.radius = radius;
        this.color = color;
        System.out.println("Circle object created");
    }

    public void setPosition(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void draw() {
        System.out.println("Drawing Circle :");
        System.out.println("Radius = " + this.radius);
        System.out.println("X Co-ordinate = " + this.xCoordinate);
        System.out.println("y Co-ordinate = " + this.yCoordinate);
        System.out.println("Color = " + this.color);
    }
}
