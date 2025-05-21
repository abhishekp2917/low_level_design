package BehaviouralPattern.VisitorPattern.example1.Solution;

public interface OfferVisitor {
    
    public void bronzeCardVisitor(BronzeCard bronzeCard);
    public void silverCardVisitor(SilverCard silverCard);
    public void goldCardVisitor(GoldCard goldCard);
}
