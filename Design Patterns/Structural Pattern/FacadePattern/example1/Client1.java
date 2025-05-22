public class Client1 {
    
    public static void main(String[] args) {
        
        // Create a Card object with card number and owner name
        Card creditCard = new Card("8976-0098-1123", "Jhon Doe");
        
        // Create instances of the subsystem services
        CardValidator cardValidator = new CardValidatorImpl();
        PaymentProcessor paymentProcessor = new StripePaymentProcessor();
        NotificationService notificationService = new EmailNotificationService();
        
        // Create the Facade by passing the subsystem instances
        PaymentFacade paymentFacade = new PaymentFacade(cardValidator, paymentProcessor, notificationService);

        // Use the Facade to make a payment with simplified method call
        paymentFacade.makePayment(creditCard, 1000);
        // Client code does not need to interact directly with
        // validation, processing, and notification services,
        // the Facade handles the coordination internally.
    }
}
