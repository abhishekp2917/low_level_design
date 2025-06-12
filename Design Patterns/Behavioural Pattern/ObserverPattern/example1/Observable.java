import java.util.ArrayList;
import java.util.List;

/**
 * Observable (also known as Subject in the Observer pattern).
 *
 * This abstract class represents the publisher or source of truth
 * that holds a list of subscribers (observers) interested in changes to its state.
 * When the state changes, all registered subscribers are notified.
 */
public abstract class Observable {

    // List of observers/subscribers interested in updates from this Observable
    private List<Subscriber> subscribers;

    // Optional: a name to identify this observable instance (e.g., channel name)
    public String name;

    /**
     * Constructor to initialize the Observable with a name and empty list of subscribers.
     */
    Observable(String name) {
        this.subscribers = new ArrayList<>();
        this.name = name;
    }

    /**
     * Method to allow a Subscriber to subscribe to this Observable.
     * Adds the subscriber to the internal list.
     */
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    /**
     * Method to allow a Subscriber to unsubscribe from this Observable.
     * Removes the subscriber from the internal list.
     */
    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    /**
     * Notifies all current subscribers that an update has occurred.
     * This triggers the Subscriber's notify() method, passing this Observable.
     */
    public void notifySubscribers() {
        subscribers.stream().forEach(subscriber -> {
            subscriber.notify(this); // Calls the subscriber's reaction logic
        });
    }

    /**
     * Abstract method to be implemented by concrete subclasses.
     * This method should define how this Observable updates its own state.
     * Typically called before notifySubscribers().
     */
    public abstract void update();
}
