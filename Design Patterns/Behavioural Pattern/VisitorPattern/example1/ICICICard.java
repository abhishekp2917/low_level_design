/**
 * ICICICard is a concrete implementation of the CreditCard interface.
 * It represents one specific type of credit card that can be visited 
 * by different Visitor implementations to perform various operations.
 */
public class ICICICard implements CreditCard {

    /**
     * Accepts a visitor and calls its method specific to ICICICard.
     * This enables the visitor to apply type-specific logic to this card.
     */
    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.iciciCardVisitor(this);
    }
}
