package BehaviouralPattern.CommandPattern.example1.Solution;

/* 
    remote controller class which will use different command object to implement 
    logic to turn On and Off various appliance similar to amazon alexa
*/
public class RemoteContoller {

    Light kitchenLight, roomLight;
    MusicPlayer musicPlayer;

    public RemoteContoller(Light kitchenLight, Light roomLight, MusicPlayer musicPlayer) {
        this.kitchenLight = kitchenLight;
        this.roomLight = roomLight;
        this.musicPlayer = musicPlayer;
    }
    
    // press one to turn On room light
    public void pressOne() {
        Command turnOnRoomLight = new TurnOnLight(this.roomLight);
        turnOnRoomLight.execute();
    }

    // press two to turn Off room light
    public void pressTwo() {
        Command turnOffRoomLight = new TurnOffLight(this.roomLight);
        turnOffRoomLight.execute();
    }

    // press three to turn on kitchen light
    public void pressThree() {
        Command turnOnKitchenLight = new TurnOnLight(this.kitchenLight);
        turnOnKitchenLight.execute();
    }

    // press four to turn Off kitchen light
    public void pressFour() {
        Command turnOffKitchenLight = new TurnOffLight(this.kitchenLight);
        turnOffKitchenLight.execute();
    }

    // press five to turn On music player
    public void pressFive() {
        Command turnOnMusicPlayer = new TurnOnMusicPlayer(this.musicPlayer);
        turnOnMusicPlayer.execute();
    }

    // press six to turn Off music player
    public void pressSix() {
        Command turnOffMusicPlayer = new TurnOffMusicPlayer(this.musicPlayer);
        turnOffMusicPlayer.execute();
    }
}