package StructuralPattern.FacadePattern.example1.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        /* 
            creating shapeInterface objet from which we will make various shapes 
        */
        ShapeInterface shapeCreator = new ShapeInterface();

        shapeCreator.drawSquare(100, 200, 50.5, 50.5);

        System.out.println();

        shapeCreator.drawRectangle(120.6, 200.5, 50.5,150.5);

        System.out.println();

        shapeCreator.drawRhombus(10, 20, 150.5, 150.5);
    }
}
