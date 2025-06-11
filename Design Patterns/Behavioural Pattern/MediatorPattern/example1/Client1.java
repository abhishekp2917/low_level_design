// Client class to demonstrate the Mediator Pattern in action.
public class Client1 {
    public static void main(String[] args) {
        // Create a concrete mediator
        AuctionMediator auction = new Auction();

        // Create and register bidders
        Bidder john = new ConcreteBidder(auction, "John");
        Bidder alice = new ConcreteBidder(auction, "Alice");
        Bidder bob = new ConcreteBidder(auction, "Bob");

        // Simulate bidding process
        john.bid(100);
        alice.bid(150);
        bob.bid(120);
        john.bid(200);
    }
}
