package StructuralPattern.FacadePattern.example1.Problem;

public class Client1 {
    
    public static void main(String[] args) {
        
        /* 
            creating various shape object to draw those objects but in this way
            if we make some changes in object class then we have to modify it here 
            also
        */
        Quadrilateral square = new Square(100, 200, 50.5, 50.5);
        Quadrilateral rectangle = new Rectangle(120.6, 200.5, 50.5,150.5);
        Quadrilateral rhombus = new Rhombus(10, 20, 150.5, 150.5);

        /* 
            drawing sqaure using square objects
        */
        square.draw();

        System.out.println();

        /* 
            drawing rectangle using rectangle objects
        */
        rectangle.draw();

        System.out.println();

        /* 
            drawing rhombus using rhombus objects
        */
        rhombus.draw();
    }
}
