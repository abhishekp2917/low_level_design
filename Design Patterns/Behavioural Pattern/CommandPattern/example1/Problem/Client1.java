public class Client1 {
    public static void main(String[] args) {
        
        // creating Broker object which will invoke commands
        Broker sensexBroker = new Broker("sensexBroker");
        
        // creating various stocks object
        Stock microsoftStock = new Stock("Microsoft", 20000.0);
        Stock paytmStock = new Stock("Paytm", 100.0);
        Stock jioStock = new Stock("Jio", 500.0);

        // broker taking orders of buying and selling different stocks 
        sensexBroker.takeBuyOrder(microsoftStock);
        sensexBroker.takeBuyOrder(paytmStock);
        sensexBroker.takeSellOrder(microsoftStock);
        sensexBroker.takeBuyOrder(jioStock);

        // broker completing orders
        sensexBroker.completeOrders();
    }
}
