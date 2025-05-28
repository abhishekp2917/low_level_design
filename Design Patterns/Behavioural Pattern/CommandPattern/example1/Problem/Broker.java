import java.util.ArrayList;
import java.util.List;

/* 
    Broker is an invoker class which will use maintain separate list of stocks based on the command
    lists like sellOrders to sell the stock and buyOrders to buy them

    Here broker needs to know how to sell and buy the stock which makes it tight coupled.
    Additionally, it is difficult to add new commands without changing Broker.
*/
public class Broker {
    
    private String name;
    private List<Stock> buyOrders;
    private List<Stock> sellOrders;

    public Broker(String name) {
        this.name = name;
        this.buyOrders = new ArrayList<>();
        this.sellOrders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // method to take orders for buying stock
    public void takeBuyOrder(Stock stock) {
        buyOrders.add(stock);
    }

    // method to take orders for selling stock
    public void takeSellOrder(Stock stock) {
        sellOrders.add(stock);
    }

    // method to complete the orders present in buy and sell order list
    public void completeOrders() {
        for(Stock stock : buyOrders) {
            stock.buy();
        }
        for(Stock stock : sellOrders) {
            stock.sell();
        }
        buyOrders.clear();
        sellOrders.clear();
    }

}
