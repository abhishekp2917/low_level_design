package BehaviouralPattern.VisitorPattern.example1.Solution;

public class GoldCard implements CreditCard{

    @Override
    public void acceptOffer(OfferVisitor offer) {
        offer.goldCardVisitor(this);
    }
}
