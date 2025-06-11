// Mediator interface defines the contract for communication.
// It allows placing a bid and registering bidders to the auction.
public interface AuctionMediator {
    void placeBid(Bidder bidder, int amount); // For placing a bid in the auction
    void registerBidder(Bidder bidder);       // To register a bidder with the mediator
}
