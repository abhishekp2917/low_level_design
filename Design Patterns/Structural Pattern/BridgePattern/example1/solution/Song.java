package StructuralPattern.BridgePattern.example1.solution;

/* 
    creating Song resource to show it in different views
*/
public class Song implements Resource{
    
    private String singer;
    private String title;

    Song(String singer, String title) {
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

    /*
        overriding intro method to show Song intro 
    */
    @Override
    public void intro() {
        System.out.println("Song Title : " + this.title);
    }

    /*
        overriding intro method to show Song description 
    */
    @Override
    public void description() {
        System.out.println("Singer : " + this.singer);
    }
}
