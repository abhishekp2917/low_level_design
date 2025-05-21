package StructuralPattern.BridgePattern.example1.solution;


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

    public double getViewHeight() {
        return viewHeight;
    }

    public double getViewWidth() {
        return viewWidth;
    }

    public void setViewHeight(double viewHeight) {
        this.viewHeight = viewHeight;
    }

    public void setViewWidth(double viewWidth) {
        this.viewWidth = viewWidth;
    }

    public abstract void show();

    public abstract void hide();
}
