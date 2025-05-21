package BehaviouralPattern.VisitorPattern.example1.Solution;

public class BronzeCard implements CreditCard{

    @Override
    public void acceptOffer(OfferVisitor offer) {
        offer.bronzeCardVisitor(this);
    }
}
