

public class Client1 {
    
    public static void main(String[] args) {
        
        /*
         * Using Strategy Pattern to choose the payment method dynamically at runtime.
         * 
         * Instead of hardcoding payment logic, we encapsulate different payment methods
         * (UPI, Debit Card, etc.) as separate strategy classes implementing a common interface.
         * 
         * This allows us to change the payment behavior easily without modifying the context class.
         */

        // Use UPI payment method
        PaymentStrategy upi = new UPIPayment("john@upi");

        // Create payment gateway with UPI strategy
        PaymentGateway paymentGateway = new PaymentGateway(upi);

        // Make payment of ₹250 using UPI
        paymentGateway.makePayment(250.0);

        // Create Debit Card payment strategy
        PaymentStrategy debitCard = new DebitCardPayment("1234-5678-9012-3456", "John Doe");

        // Change the strategy to Debit Card at runtime
        paymentGateway.setStrategy(debitCard);

        // Make payment of ₹500 using Debit Card
        paymentGateway.makePayment(500.0);
    }
}
