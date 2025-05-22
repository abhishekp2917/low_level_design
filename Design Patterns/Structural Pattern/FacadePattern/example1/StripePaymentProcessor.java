// StripePaymentProcessor is a concrete implementation of the PaymentProcessor interface.
// It simulates payment processing through Stripe.
public class StripePaymentProcessor implements PaymentProcessor {

    // This method processes the payment using the given card and amount.
    @Override
    public void process(Card card, double amount) {
        // Simulates successful payment by printing a confirmation message.
        System.out.println(String.format("Payment of Rs.%d from Card : %s completed successfully.", amount, card.cardNumber));   
    }
}
