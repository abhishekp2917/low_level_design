package StructuralPattern.BridgePattern.example1.problem;

/* 
    creating abstract class view which is use to show and hide various resources
*/
public abstract class View {
    
    protected double viewHeight;
    protected double viewWidth;

    View(double viewHeight, double viewWidth) {
        this.viewHeight = viewHeight;
        this.viewWidth = viewWidth;
    }

    public abstract void show();
}
