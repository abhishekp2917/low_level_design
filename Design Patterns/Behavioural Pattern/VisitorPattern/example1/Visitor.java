/**
 * Visitor defines a set of operations that can be performed on different
 * types of credit card objects. It allows adding new behaviors to existing
 * class hierarchies without modifying the classes.
 *
 * This interface is a key part of the Visitor design pattern, enabling 
 * double dispatch to execute behavior based on both the visitor type
 * and the element it visits.
 */
public interface Visitor {

    /**
     * Defines an operation to be performed on SBICard.
     * Called when an SBICard accepts this visitor.
     */
    public void sbiCardVisitor(SBICard sbiCard);

    /**
     * Defines an operation to be performed on HDFCCard.
     * Called when an HDFCCard accepts this visitor.
     */
    public void hdfcCardVisitor(HDFCCard hdfcCard);

    /**
     * Defines an operation to be performed on ICICICard.
     * Called when an ICICICard accepts this visitor.
     */
    public void iciciCardVisitor(ICICICard iciciCard);
}
