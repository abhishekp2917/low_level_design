package StructuralPattern.FacadePattern.example1.Solution;

/* 
    shapeInterface class which acts as an interface between client and Facade
*/
public class ShapeInterface {
    
    /* 
        this method draws square 
    */
    public void drawSquare(double xCoordinate, double yCoordinate, double height, double width) {
        Quadrilateral square = new Square(xCoordinate, yCoordinate, height, width);
        square.draw();
    }

    /* 
        this method draws reactangle 
    */
    public void drawRectangle(double xCoordinate, double yCoordinate, double height, double width) {
        Quadrilateral rectangle = new Rectangle(xCoordinate, yCoordinate, height, width);
        rectangle.draw();
    }

    /* 
        this method draws rhombus 
    */
    public void drawRhombus(double xCoordinate, double yCoordinate, double height, double width) {
        Quadrilateral rhombus = new Rhombus(xCoordinate, yCoordinate, height, width);
        rhombus.draw();
    }
}
