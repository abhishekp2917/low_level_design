package BehaviouralPattern.VisitorPattern.example1.Solution;

public interface CreditCard {
    
    public void acceptOffer(OfferVisitor offer);
}
