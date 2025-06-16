/**
 * Client1 demonstrates the use of the Visitor design pattern
 * with different types of credit cards and multiple visitor implementations.
 * 
 * It shows how behavior (like discounts and annual fees) can be applied
 * to card objects without modifying their classes.
 */
public class Client1 {

    public static void main(String[] args) {

        // Creating credit card objects using the interface reference
        CreditCard sbiCard = new SBICard();
        CreditCard hdfcCard = new HDFCCard();
        CreditCard iciciCard = new ICICICard();

        // Creating visitor objects to perform different operations
        Visitor discountVisitor = new DiscountVisitor();       // Applies discounts
        Visitor annualFeeVisitor = new AnnualFeeVisitor();     // Displays annual fees

        // Applying the discount logic using the visitor on each card
        sbiCard.acceptVisitor(discountVisitor);
        hdfcCard.acceptVisitor(discountVisitor);
        iciciCard.acceptVisitor(discountVisitor);

        // Applying the annual fee logic using the visitor on each card
        sbiCard.acceptVisitor(annualFeeVisitor);
        hdfcCard.acceptVisitor(annualFeeVisitor);
        iciciCard.acceptVisitor(annualFeeVisitor);
    }
}
