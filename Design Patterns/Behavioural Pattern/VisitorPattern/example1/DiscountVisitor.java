/**
 * DiscountVisitor is a concrete implementation of the Visitor interface.
 * It defines the discount logic specific to each type of credit card.
 * This class enables separating the discount rules from the card classes themselves.
 */
public class DiscountVisitor implements Visitor {

    /**
     * Applies a 5% discount specific to SBI Card.
     * Called when an SBICard accepts this visitor.
     */
    @Override
    public void sbiCardVisitor(SBICard sbiCard) {
        System.out.println("SBI Card: 5% discount applied.");
    }

    /**
     * Applies a 10% discount specific to HDFC Card.
     * Called when an HDFCCard accepts this visitor.
     */
    @Override
    public void hdfcCardVisitor(HDFCCard hdfcCard) {
        System.out.println("HDFC Card: 10% discount applied.");
    }

    /**
     * Applies a 20% discount specific to ICICI Card.
     * Called when an ICICICard accepts this visitor.
     */
    @Override
    public void iciciCardVisitor(ICICICard iciciCard) {
        System.out.println("ICICI Card: 20% discount applied.");
    }    
}
