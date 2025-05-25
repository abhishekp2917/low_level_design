// Concrete Strategy 1 - UPI Payment
public class UPIPayment implements PaymentStrategy {

    private String upiId;

    // Constructor to initialize UPI ID
    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        // Simulate UPI payment logic
        System.out.println("Paid ₹" + amount + " using UPI ID: " + upiId);
    }
}
