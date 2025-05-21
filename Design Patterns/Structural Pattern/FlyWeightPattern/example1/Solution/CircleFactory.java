package StructuralPattern.FlyWeightPattern.example1.Solution;

import java.util.HashMap;

/* 
    CircleFactory class which stores circle objects and returns it based 
    on requirements
*/
public class CircleFactory {

    /* 
        HashMap to store all the created circle objects and if there is a requirement
        of circle with color that is present in this hashmap that it can be reused
    */
    private static final HashMap <Color, Circle> circleMap = new HashMap<>();

    /* 
        method that returns the circle either by creating a new circle object or by
        returning it from HashMap
    */
    public static Circle getCircle(double radius, double xCoordinate, double yCoordinate, Color color) {
        Circle circleObj = circleMap.get(color);

        /* 
            if circle object is not present that create new object
        */
        if(circleObj==null) {
            circleObj = new Circle(radius, xCoordinate, yCoordinate, color);
            circleMap.put(color, circleObj);
        }
        /* 
            if circle is present that modify that circle and return it
        */
        else{
            circleObj.setRadius(radius);
            circleObj.setxCoordinate(xCoordinate);
            circleObj.setyCoordinate(yCoordinate);
        }
        return circleObj;
    }
    
}
