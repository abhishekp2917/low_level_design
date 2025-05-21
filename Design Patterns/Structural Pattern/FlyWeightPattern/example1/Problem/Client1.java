package StructuralPattern.FlyWeightPattern.example1.Problem;

public class Client1 {
    
    public static void main(String[] args) {
        
        /* 
            creating 100 cricle objects with various different attributes
        */ 
        for(int i=1; i<=100; i++) {

            Circle circle = new Circle(getRandomRadius(), getRandomXCoordinate(), getRandomYCoordinate(), getRandomColor());
            circle.draw();
            System.out.println();
        }

        System.out.println("Total Circle object created = " + Circle.circleCount);
    }

    public static Color getRandomColor() {

        int index = (int) (Math.random()*(Color.values().length-1));
        return Color.values()[index];
    }

    public static double getRandomRadius() {

        return Math.random()*(100);
    }

    public static double getRandomXCoordinate() {

        return Math.random()*(1000);
    }

    public static double getRandomYCoordinate() {

        return Math.random()*(1000);
    }
}
