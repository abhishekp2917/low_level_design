package StructuralPattern.FacadePattern.example1.Solution;

public class Rectangle extends Quadrilateral{

    public Rectangle(double xCoordinate, double yCoordinate, double height, double width) {
        super(xCoordinate, yCoordinate, height, width);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle :");
        System.out.println("Height = " + this.height);
        System.out.println("Width = " + this.width);
        System.out.println("X Co-ordinate = " + this.xCoordinate);
        System.out.println("y Co-ordinate = " + this.yCoordinate);
    }
}
