/* 
    creating ShortView class to show resources in long view form
*/
public class ShortView extends View{

    // resource to be shown in short view form
    Resource resource;

    ShortView(double viewHeight, double viewWidth, Resource resource) {
        super(viewHeight, viewWidth);
        this.resource = resource;
    }

    @Override
    public void show() {
        System.out.println("Showing Short View");
        resource.intro();
    }
}
