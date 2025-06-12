/**
 * Subscriber (Observer interface in the Observer pattern).
 *
 * This interface should be implemented by any class that wants to
 * observe and react to changes in an Observable (Subject).
 */
public interface Subscriber {

    /**
     * Called by the Observable when it undergoes a state change.
     * Implementing classes define how they respond to the update.
     */
    void notify(Observable observable);
}
