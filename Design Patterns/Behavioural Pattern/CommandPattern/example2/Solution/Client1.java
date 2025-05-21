package BehaviouralPattern.CommandPattern.example2.Solution;

public class Client1 {
    public static void main(String[] args) {
        
        // creating Broker object which will invoke commands
        Broker sensexBroker = new Broker("sensexBroker");

        // creating various stocks object
        Stock microsoftStock = new Stock("Microsoft", 20000.0);
        Stock paytmStock = new Stock("Paytm", 100.0);
        Stock jioStock = new Stock("Jio", 500.0);

        // broker taking orders of buying and selling different stocks 
        sensexBroker.takeOrders(new BuyStock(microsoftStock));
        sensexBroker.takeOrders(new BuyStock(paytmStock));
        sensexBroker.takeOrders(new SellStock(microsoftStock));
        sensexBroker.takeOrders(new BuyStock(jioStock));

        // broker completing orders
        sensexBroker.completeOrders();
    }
}
