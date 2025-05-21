package StructuralPattern.BridgePattern.example1.problem;

public class ArtistShortView extends View{

    private String name;
    
    ArtistShortView(int viewHeight, int viewWidth, String name) {
        super(viewHeight, viewWidth, true);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("Showing Short view \nArtist : " + this.getName());
    }

    @Override
    public void hide() {
        System.out.println("Hiding Short view \nArtist : " + this.getName());
    }
}
