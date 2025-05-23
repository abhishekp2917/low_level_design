/* 
    creating LongView class to show resources in long view form
*/
public class LongView extends View{

    // resource to be shown in long view form
    Resource resource;

    LongView(double viewHeight, double viewWidth, Resource resource) {
        super(viewHeight, viewWidth);
        this.resource = resource;
    }

    @Override
    public void show() {
        System.out.println("Showing Long View");
        resource.intro();
        resource.description();
    }
}
