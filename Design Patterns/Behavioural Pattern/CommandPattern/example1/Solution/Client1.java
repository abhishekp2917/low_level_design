package BehaviouralPattern.CommandPattern.example1.Solution;

public class Client1 {
    
    public static void main(String[] args) {

        // creating appliance objects
        Light kitchenLight = new Light("kitchen light");
        Light roomlight = new Light("room light");
        MusicPlayer musicPlayer1 = new MusicPlayer("musicPlayer1");

        // creating amazon alexa object which will be used to controll various appliances
        AmazonAlexa alexa = new AmazonAlexa(kitchenLight, roomlight, musicPlayer1);

        // creating remote controller object which will be used to controll various appliances
        RemoteContoller controller = new RemoteContoller(kitchenLight, roomlight, musicPlayer1);

        // contolling kitchen light using alexa
        alexa.turnOnKitchenLight();
        alexa.turnOffKitchenLight();

        // contolling kitchen light using controller
        controller.pressThree();
        controller.pressFour();

        // controlling music player using alexa
        alexa.turnOnMusicPlayer();

        // controlling music player using controller
        controller.pressFive();

        // controlling room light using alexa
        alexa.turnOnRoomLight();
        alexa.turnOffRoomLight();

        // controlling room light using controller
        controller.pressOne();
        controller.pressTwo();
    }
}
