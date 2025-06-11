// Concrete implementation of a bidder.
// Implements logic to handle bid placement and responses.
public class ConcreteBidder extends Bidder {

    public ConcreteBidder(AuctionMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void bid(int amount) {
        System.out.println(name + " is bidding $" + amount);
        mediator.placeBid(this, amount); // All bids go through the mediator
    }

    @Override
    public void notifyNewHighestBid(String bidderName, int bidAmount) {
        System.out.println(name + " has been notified: " + bidderName +
                " is now the highest bidder with $" + bidAmount);
    }

    @Override
    public void notifyOutbid(int yourBid, int currentHighest) {
        System.out.println(name + ", your bid of $" + yourBid +
                " was too low. Current highest bid is $" + currentHighest);
    }
}
