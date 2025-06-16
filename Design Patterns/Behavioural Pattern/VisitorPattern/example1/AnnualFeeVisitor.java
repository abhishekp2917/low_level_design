/**
 * AnnualFeeVisitor is a concrete implementation of the Visitor interface.
 * It encapsulates the logic for calculating or displaying the annual fee
 * for different types of credit cards.
 */
public class AnnualFeeVisitor implements Visitor {

    /**
     * Displays the annual fee for SBI Card.
     * Called when an SBICard accepts this visitor.
     */
    @Override
    public void sbiCardVisitor(SBICard sbiCard) {
        System.out.println("Annual fee for SBI Card: $20");
    }

    /**
     * Displays the annual fee for HDFC Card.
     * Called when an HDFCCard accepts this visitor.
     */
    @Override
    public void hdfcCardVisitor(HDFCCard hdfcCard) {
        System.out.println("Annual fee for HDFC Card: $50");
    }

    /**
     * Displays the annual fee for ICICI Card.
     * Called when an ICICICard accepts this visitor.
     */
    @Override
    public void iciciCardVisitor(ICICICard iciciCard) {
        System.out.println("Annual fee for ICICI Card: $100");
    }
}
