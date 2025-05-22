// EmailNotificationService is a concrete implementation of NotificationService
// that simulates sending notifications via email.
public class EmailNotificationService implements NotificationService {

    // Sends an email notification with the provided message.
    @Override
    public void notifyUser(String message) {
        System.out.println(String.format("Message: %s mailed successfully.", message));
    }
}
