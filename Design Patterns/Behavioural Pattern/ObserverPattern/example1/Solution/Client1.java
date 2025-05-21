package BehaviouralPattern.ObserverPattern.example1.Solution;

public class Client1 {
    public static void main(String[] args) {
        
        // creating new channel
        Channel channel1 = new Channel("Gamming Channel");

        // creating new subscribers
        Subscriber subscriber1 = new Subscriber("Abhishek");
        Subscriber subscriber2 = new Subscriber("Ravi");
        Subscriber subscriber3 = new Subscriber("Suraj");
        Subscriber subscriber4 = new Subscriber("Anjali");

        // adding all the subscriber to the channel1
        channel1.addSubscriber(subscriber1);
        channel1.addSubscriber(subscriber2);
        channel1.addSubscriber(subscriber3);
        channel1.addSubscriber(subscriber4);

        /* 
            uploading new videos which will notify all the subscribers about the update
        */
        channel1.uploadVideo(new Video("PUBG", "How to play PUBG"));
        channel1.uploadVideo(new Video("XBOX", "How to configure XBOX"));
    }
}
