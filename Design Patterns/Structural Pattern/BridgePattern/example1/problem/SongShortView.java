package StructuralPattern.BridgePattern.example1.problem;

public class SongShortView extends View{
    
    private String singer;

    SongShortView(int viewHeight, int viewWidth, String singer) {
        super(viewHeight, viewWidth, true);
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public void show() {
        System.out.println("Showing Short view \nSinger : " + this.getSinger());
    }

    @Override
    public void hide() {
        System.out.println("Hiding Short view \nSinger : " + this.getSinger());
    }
}
