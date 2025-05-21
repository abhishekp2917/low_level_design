package StructuralPattern.BridgePattern.example1.solution;


/* 
    creating ShortView class to show resources in long view form
*/
public class ShortView extends View{

    // resource to be shown in short view form
    Resource resource;

    ShortView(double viewHeight, double viewWidth, boolean scrollable, Resource resource) {
        super(viewHeight, viewWidth, scrollable);
        this.resource = resource;
    }

    @Override
    public void show() {
        System.out.println("Showing Short View");
        resource.intro();
    }

    @Override
    public void hide() {
        System.out.println("Showing Short View");
        resource.intro();
    }
    
}
