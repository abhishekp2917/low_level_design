package BehaviouralPattern.VisitorPattern.example1.Solution;

public class SilverCard implements CreditCard {

    @Override
    public void acceptOffer(OfferVisitor offer) {
        offer.silverCardVisitor(this);
    }
}
