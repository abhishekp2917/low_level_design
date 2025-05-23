package StructuralPattern.BridgePattern.example1.problem;

public class SongLongView extends View{
    
    private String singer;
    private String title;

    SongLongView(int viewHeight, int viewWidth, String singer, String title) {
        super(viewHeight, viewWidth, true);
        this.singer = singer;
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public String getTitle() {
        return title;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void show() {
        System.out.println("Showing Long view \nSinger : " + this.getSinger() + "\nSong Title : " + this.getTitle());
    }
}
