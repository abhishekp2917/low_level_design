package StructuralPattern.FacadePattern.example1.Problem;


public abstract class Quadrilateral {
    
    protected double xCoordinate;
    protected double yCoordinate;
    protected double height;
    protected double width;

    public Quadrilateral(double xCoordinate, double yCoordinate, double height, double width) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.height = height;
        this.width = width;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
    
    public abstract void draw();
}
