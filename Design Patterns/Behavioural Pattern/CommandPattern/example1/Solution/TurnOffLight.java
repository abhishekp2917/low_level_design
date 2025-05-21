package BehaviouralPattern.CommandPattern.example1.Solution;

/* 
    TurnOffLight class to turn Off the light 
*/
public class TurnOffLight implements Command{
    
    private Light light;

    public TurnOffLight(Light light) {
        this.light = light;
    }

    // method to turn Off the appliance
    @Override
    public void execute() {
        light.turnOff();
    }

    // method to do opposite of turn Off i.e. turn On
    @Override
    public void unexecute() {
        light.turnOn();
    }
}
