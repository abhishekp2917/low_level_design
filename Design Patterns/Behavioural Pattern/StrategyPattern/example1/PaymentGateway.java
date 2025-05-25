// Context Class - Accepts strategy and delegates payment logic
// This class demonstrates the use of the Strategy Design Pattern.
//
// Strategy Pattern Summary:
// The Strategy Pattern allows you to define a family of algorithms (in this case, different payment methods),
// put each of them in a separate class (like UPIPayment, DebitCardPayment, etc.), and make them interchangeable
// by encapsulating them behind a common interface (PaymentStrategy).
//
// This makes it easy to switch between payment strategies at runtime without modifying the core business logic
// in the context class (PaymentGateway).

public class PaymentGateway {

    // Reference to the current strategy (e.g., UPI, DebitCard, NetBanking)
    private PaymentStrategy paymentStrategy;

    // Constructor accepts the desired payment strategy at the time of object creation
    // Example: new PaymentGateway(new UPIPayment("user@upi"))
    public PaymentGateway(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Business method that delegates the payment operation to the strategy object.
    // The actual logic (UPI, card, or net banking) is determined by the implementation
    // of the strategy passed to this class.
    public void makePayment(double amount) {
        paymentStrategy.pay(amount); // Delegates to concrete strategy's implementation
    }

    // Allows switching the payment strategy dynamically at runtime.
    // Example: gateway.setStrategy(new DebitCardPayment(...));
    public void setStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
}
