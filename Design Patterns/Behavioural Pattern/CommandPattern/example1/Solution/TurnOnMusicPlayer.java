package BehaviouralPattern.CommandPattern.example1.Solution;


/* 
    TurnOnMusicPlayer class to turn On the music player
*/
public class TurnOnMusicPlayer implements Command {
    
    private MusicPlayer musicPlayer;

    public TurnOnMusicPlayer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    // method to turn On the music player
    @Override
    public void execute() {
        musicPlayer.turnOn();
    }

    // method to do opposite of turn On i.e. turn Off
    @Override
    public void unexecute() {
        musicPlayer.turnOff();
    }
}
