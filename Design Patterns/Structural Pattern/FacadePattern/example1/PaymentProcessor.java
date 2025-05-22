
// PaymentProcessor interface represents an abstraction for any payment gateway
// or service that can process payments using a card and a given amount.
public interface PaymentProcessor {

    // Processes the payment using the given card details and amount.
    void process(Card card, double amount);
}
