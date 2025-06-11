// Abstract class representing a bidder in the auction.
// It holds a reference to the mediator to communicate indirectly with other bidders.
public abstract class Bidder {
    protected AuctionMediator mediator;  // Reference to the mediator (Auction)
    protected String name;               // Name of the bidder

    public Bidder(AuctionMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.registerBidder(this);   // Register this bidder with the mediator
    }

    // Each bidder can place a bid through the mediator
    public abstract void bid(int amount);

    // Called when another bidder places a higher bid
    public abstract void notifyNewHighestBid(String bidderName, int bidAmount);

    // Called when this bidder places a bid that is too low
    public abstract void notifyOutbid(int yourBid, int currentHighest);
}
