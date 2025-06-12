/**
 * Client1: Demonstrates the Observer Pattern in action.
 *
 * A Channel (Observable) notifies all subscribed Users (Subscribers)
 * when it is updated.
 */
public class Client1 {
    public static void main(String[] args) {

        // Create a new YouTube channel (Observable)
        Observable channel1 = new Channel("Gaming Channel");

        // Create subscribers (Observers)
        Subscriber subscriber1 = new User("Abhishek");
        Subscriber subscriber2 = new User("Ravi");
        Subscriber subscriber3 = new User("Suraj");
        Subscriber subscriber4 = new User("Anjali");

        // Register all subscribers to the channel
        channel1.subscribe(subscriber1);
        channel1.subscribe(subscriber2);
        channel1.subscribe(subscriber3);
        channel1.subscribe(subscriber4);

        /*
         * Triggering an update on the channel.
         * This simulates a new video or any other change,
         * and will notify all subscribers.
         */
        channel1.update();
    }
}
