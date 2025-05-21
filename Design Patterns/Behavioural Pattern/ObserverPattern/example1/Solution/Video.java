package BehaviouralPattern.ObserverPattern.example1.Solution;

public class Video {
    
    private String title;
    private String description;

    public Video(String title, String description) {
        this. title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public void play() {
        System.out.println("Playing the video");
        System.out.println("Titled: "+this.title);
        System.out.println("Description: "+this.description);
    }
}
