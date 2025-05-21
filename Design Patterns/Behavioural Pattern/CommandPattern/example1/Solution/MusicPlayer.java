package BehaviouralPattern.CommandPattern.example1.Solution;

/* 
    MusicPlayer class implements Appliance
*/
public class MusicPlayer implements Appliance {

    private String name;

    public MusicPlayer(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning On the music player : " + this.name);
    }

    @Override
    public void turnOff() {
        System.out.println("Turning Off the music player : " + this.name);
    }    
}
