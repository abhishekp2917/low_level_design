package BehaviouralPattern.CommandPattern.example1.Solution;

/* 
    TurnOffMusicPlayer class to turn Off the music player
*/
public class TurnOffMusicPlayer implements Command{
    
    private MusicPlayer musicPlayer;

    public TurnOffMusicPlayer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    // method to turn Off the music player
    @Override
    public void execute() {
        musicPlayer.turnOff();
    }

    // method to do opposite of turn Off i.e. turn On
    @Override
    public void unexecute() {
        musicPlayer.turnOn();
    }
}
