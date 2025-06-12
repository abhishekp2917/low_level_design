/**
 * Concrete Observable: Channel
 *
 * Represents a specific subject that can be observed.
 * In this case, a YouTube channel that notifies subscribers when updated.
 */
public class Channel extends Observable {

    /**
     * Constructor to initialize the Channel with a name.
     */
    public Channel(String name) {
        super(name);
    }

    /**
     * Updates the channel state and notifies all subscribed users.
     * This simulates an event like uploading a new video.
     */
    @Override
    public void update() {
        System.out.println(String.format("Channel %s has been updated.", this.name));
        this.notifySubscribers();  // Notify all registered subscribers
    }
}
