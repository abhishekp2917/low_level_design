package StructuralPattern.FlyWeightPattern.example1.Problem;


/* 
    Circle class whose lots of objects is to created
*/
public class Circle {

    public static int circleCount = 0;

    private double radius;
    private double xCoordinate;
    private double yCoordinate;
    private Color color;

    public Circle(double radius, double xCoordinate, double yCoordinate, Color color) {
        this.radius = radius;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.color = color;
        circleCount++;
        System.out.println("Circle object created");
    }

    public double getRadius() {
        return radius;
    }
    
    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public Color getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
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
