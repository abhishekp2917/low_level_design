package BehaviouralPattern.CommandPattern.example1.Solution;


/* 
    AmazonAlexa class which will acts as an invoker to invoke or execute various 
    commands
*/
public class AmazonAlexa {

    Light kitchenLight, roomLight;
    MusicPlayer musicPlayer;

    public AmazonAlexa(Light kitchenLight, Light roomLight, MusicPlayer musicPlayer) {
        this.kitchenLight = kitchenLight;
        this.roomLight = roomLight;
        this.musicPlayer = musicPlayer;
    }

    public void turnOnRoomLight() {
        Command turnOnRoomLight = new TurnOnLight(this.roomLight);
        turnOnRoomLight.execute();
    }

    public void turnOffRoomLight() {
        Command turnOffRoomLight = new TurnOffLight(this.roomLight);
        turnOffRoomLight.execute();
    }

    public void turnOnKitchenLight() {
        Command turnOnKitchenLight = new TurnOnLight(this.kitchenLight);
        turnOnKitchenLight.execute();
    }

    public void turnOffKitchenLight() {
        Command turnOffKitchenLight = new TurnOffLight(this.kitchenLight);
        turnOffKitchenLight.execute();
    }

    public void turnOnMusicPlayer() {
        Command turnOnMusicPlayer = new TurnOnMusicPlayer(this.musicPlayer);
        turnOnMusicPlayer.execute();
    }

    public void turnOffMusicPlayer() {
        Command turnOffMusicPlayer = new TurnOffMusicPlayer(this.musicPlayer);
        turnOffMusicPlayer.execute();
    }
}
