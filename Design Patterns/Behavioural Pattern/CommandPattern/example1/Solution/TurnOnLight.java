package BehaviouralPattern.CommandPattern.example1.Solution;

/* 
    TurnOnLight class to turn On the light 
*/
public class TurnOnLight implements Command{

    private Light light;

    public TurnOnLight(Light light) {
        this.light = light;
    }

    // method to turn On the light
    @Override
    public void execute() {
        light.turnOn();
    }

    // method to do opposite of turn On i.e. turn Off
    @Override
    public void unexecute() {
        light.turnOff();
    }
}
