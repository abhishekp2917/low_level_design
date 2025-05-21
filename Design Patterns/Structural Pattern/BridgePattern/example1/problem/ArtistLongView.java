package StructuralPattern.BridgePattern.example1.problem;

public class ArtistLongView extends View{

    private String name;
    private String title;

    ArtistLongView(int viewHeight, int viewWidth, String name, String title) {
        super(viewHeight, viewWidth, true);
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void show() {
        System.out.println("Showing Long view \nArtist : " + this.getName() + "\nArt Title : " + this.getTitle());
    }

    @Override
    public void hide() {
        System.out.println("Hiding Long view \nArtist : " + this.getName() + "\nArt Title : " + this.getTitle());
    }
}
