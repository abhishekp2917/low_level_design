package BehaviouralPattern.CommandPattern.example1.Solution;


/* 
    Light class implements Appliance
*/
public class Light implements Appliance {

    private String name;

    public Light(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning On the Light : " + this.name);
    }

    @Override
    public void turnOff() {
        System.out.println("Turning Off the light : " + this.name);        
    }
    
}
