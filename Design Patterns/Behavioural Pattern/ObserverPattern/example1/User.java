/**
 * Concrete Observer: User
 *
 * Represents a user who subscribes to an Observable (e.g., a YouTube channel).
 * Implements the Subscriber interface and defines how to react to notifications.
 */
class User implements Subscriber {

    private String name;

    public User(String name) {
        this.name = name;
    }

    /**
     * Called when the Observable notifies its subscribers of an update.
     * This method prints a message identifying the user and the source of the update.
     */
    @Override
    public void notify(Observable observable) {
        // Assumes Observable has a public getter for its name
        System.out.println(String.format(
            "User %s received notification. Channel %s has been updated.",
            this.name,
            observable.name
        ));
    }
}
