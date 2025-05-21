package StructuralPattern.FacadePattern.example1.Solution;

public class Square extends Quadrilateral{
    
    public Square(double xCoordinate, double yCoordinate, double height, double width) {
        super(xCoordinate, yCoordinate, height, width);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square :");
        System.out.println("Height = " + this.height);
        System.out.println("Width = " + this.width);
        System.out.println("X Co-ordinate = " + this.xCoordinate);
        System.out.println("y Co-ordinate = " + this.yCoordinate);
    }
    
}
