package StructuralPattern.BridgePattern.example1.problem;

/* 
    creating abstract class view which is use to show and hide various resources
*/
public abstract class View {
    
    protected double viewHeight;
    protected double viewWidth;
    protected boolean scrollable;

    View(double viewHeight, double viewWidth, boolean scrollable) {
        this.viewHeight = viewHeight;
        this.viewWidth = viewWidth;
        this.scrollable = scrollable;
    }

    public abstract void show();

    public abstract void hide();
}
