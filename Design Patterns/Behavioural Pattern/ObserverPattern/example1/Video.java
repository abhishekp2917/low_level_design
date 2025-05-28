package BehaviouralPattern.ObserverPattern.example1.Solution;

public class Video {
    
    public String title;
    public String description;

    public Video(String title, String description) {
        this. title = title;
        this.description = description;
    }
    
    public void play() {
        System.out.println("Playing the video");
        System.out.println("Titled: "+this.title);
        System.out.println("Description: "+this.description);
    }
}
