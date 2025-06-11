// ConcreteMediator implements the AuctionMediator interface.
// It contains the business logic to manage bidding and communication between bidders.

import java.util.ArrayList;
import java.util.List;

class Auction implements AuctionMediator {
    private List<Bidder> bidders = new ArrayList<>(); // List of all registered bidders
    private Bidder highestBidder;                    // Current highest bidder
    private int highestBid = 0;                      // Current highest bid

    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder); // Add bidder to the list
    }

    @Override
    public void placeBid(Bidder bidder, int amount) {
        // If the new bid is higher than the current highest bid
        if (amount > highestBid) {
            highestBid = amount;
            highestBidder = bidder;
            notifyBidders(bidder); // Inform all other bidders
        } else {
            // Notify the bidder that their bid was too low
            bidder.notifyOutbid(amount, highestBid);
        }
    }

    // Notify all bidders except the one who placed the highest bid
    private void notifyBidders(Bidder newHighest) {
        for (Bidder bidder : bidders) {
            if (bidder != newHighest) {
                bidder.notifyNewHighestBid(newHighest.getName(), highestBid);
            }
        }
    }
}
