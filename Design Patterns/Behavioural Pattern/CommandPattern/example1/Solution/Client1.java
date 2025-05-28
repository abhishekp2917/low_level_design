public class Client1 {
    public static void main(String[] args) {
        
        // creating Broker object which will invoke commands
        Broker1 sensexBroker = new Broker1("sensexBroker");

        // creating various stocks object
        Stock microsoftStock = new Stock("Microsoft", 20000.0);
        Stock paytmStock = new Stock("Paytm", 100.0);
        Stock jioStock = new Stock("Jio", 500.0);

        // broker taking orders of buying and selling different stocks 
        sensexBroker.takeOrder(new BuyStock(microsoftStock));
        sensexBroker.takeOrder(new BuyStock(paytmStock));
        sensexBroker.takeOrder(new SellStock(microsoftStock));
        sensexBroker.takeOrder(new BuyStock(jioStock));

        // broker completing orders
        sensexBroker.completeOrders();

        // Undoing the last 2 operations
        System.out.println("\nUndoing last 2 operations:");
        sensexBroker.undoLastOrder();
        sensexBroker.undoLastOrder();

        // Undoing again just to demonstrate
        System.out.println("\nUndoing remaining operations:");
        sensexBroker.undoLastOrder();
        sensexBroker.undoLastOrder();

        // Trying to undo beyond history
        sensexBroker.undoLastOrder();
    }
}
