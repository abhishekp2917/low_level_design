/**
 * HDFCCard is a concrete implementation of the CreditCard interface.
 * It represents a specific type of credit card that can be visited 
 * by different Visitor implementations to perform operations.
 */
public class HDFCCard implements CreditCard {

    /**
     * Accepts a visitor and invokes the visitor's method specific to HDFCCard.
     * This allows external logic to be applied to the card without changing its structure.
     */
    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.hdfcCardVisitor(this);
    }
}
