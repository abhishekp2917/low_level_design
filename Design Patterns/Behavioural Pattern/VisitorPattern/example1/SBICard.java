/**
 * SBICard is a concrete implementation of the CreditCard interface.
 * It represents a specific type of credit card that supports being 
 * visited by various Visitor implementations to apply custom operations.
 */
public class SBICard implements CreditCard {

    /**
     * Accepts a visitor and triggers the visitor's logic specific to SBICard.
     * This allows the visitor to execute card-specific operations without
     * modifying the SBICard class itself.
     */
    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.sbiCardVisitor(this);
    }
}
