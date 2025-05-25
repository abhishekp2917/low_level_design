// Concrete Strategy 2 - Debit Card Payment
public class DebitCardPayment implements PaymentStrategy {

    private String cardNumber;
    private String cardHolderName;

    // Constructor to initialize debit card details
    public DebitCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        // Simulate debit card payment logic
        System.out.println("Paid ₹" + amount + " using Debit Card: " + cardNumber + " (Cardholder: " + cardHolderName + ")");
    }
}
