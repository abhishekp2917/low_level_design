/**
 * This class acts as a Facade by providing a simplified interface
 * to a complex subsystem consisting of card validation, payment processing and user notification services.
 * 
 * Instead of client code interacting with each subsystem directly,
 * the facade consolidates these interactions into a single method call, hiding the complexities and dependencies from the client.
 */
public class PaymentFacade {

    // CardValidator subsystem - responsible for validating card details
    private CardValidator cardValidator;
    
    // PaymentProcessor subsystem - responsible for processing the payment
    private PaymentProcessor paymentProcessor;
    
    // NotificationService subsystem - responsible for notifying the user
    private NotificationService notificationService;

    // Constructor for injecting the subsystem dependencies
    public PaymentFacade(CardValidator cardValidator, PaymentProcessor paymentProcessor, NotificationService notificationService) {
        this.cardValidator = cardValidator;
        this.paymentProcessor = paymentProcessor;
        this.notificationService = notificationService;
    }
    
    /**
     * Simplified method for making a payment.
     * This method internally coordinates with multiple subsystems:
     * - Validates the card
     * - Processes the payment
     * - Notifies the user of the payment status
     * 
     * Clients interact only with this method instead of multiple subsystem interfaces,
     * thus reducing coupling and simplifying usage.
     */
    public void makePayment(Card card, double amount) {
        if(this.cardValidator.validate(card)) {
            this.paymentProcessor.process(card, amount);
            this.notificationService.notifyUser("Payment successfully completed.");
        }
    }
}
