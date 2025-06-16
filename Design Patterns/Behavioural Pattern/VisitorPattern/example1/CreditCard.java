/**
 * The CreditCard interface represents an element in the Visitor Design Pattern.
 * It defines a method to accept a visitor, enabling operations to be performed 
 * on the object without modifying its structure.
 */
public interface CreditCard {

    /**
     * Accepts a visitor that will perform an operation on the credit card.
     * The actual operation is defined in the visitor implementation, and
     * the concrete credit card class will call the appropriate method on the visitor.
     */
    public void acceptVisitor(Visitor visitor);
}
