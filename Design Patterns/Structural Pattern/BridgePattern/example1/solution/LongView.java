package StructuralPattern.BridgePattern.example1.solution;


/* 
    creating LongView class to show resources in long view form
*/
public class LongView extends View{

    // resource to be shown in long view form
    Resource resource;

    LongView(double viewHeight, double viewWidth, boolean scrollable, Resource resource) {
        super(viewHeight, viewWidth, scrollable);
        this.resource = resource;
    }

    @Override
    public void show() {
        System.out.println("Showing Long View");
        resource.intro();
        resource.description();
    }

    @Override
    public void hide() {
        System.out.println("Hiding Long View");
        resource.intro();
        resource.description();
    }
    
}
