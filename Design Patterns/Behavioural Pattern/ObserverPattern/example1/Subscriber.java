package BehaviouralPattern.ObserverPattern.example1.Solution;

/* 
    Subscriber class which will store all the details of subscriber or observer
*/
public class Subscriber {
    
    public String name;

    Subscriber(String name) {
        this.name = name;
    }

    /* 
        method to get update about videos from the channel passed as argument 
        which will be used by the observable class to notify the subscriber
    */
    public void update(Channel channel) {
        System.out.println("Hey " + this.name + "! " + channel.getChannelName() + " has uploaded new video");
    }
}
