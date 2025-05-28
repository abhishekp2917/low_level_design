import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
    Broker is an invoker class which will use Command objects to execute various
    commands like SellStock to sell the stock and BuyStock to buy the stock
*/
public class Broker {
    
    private String name;
    private List<Command> orders;
    private Stack<Command> orderHistory; // for undo

    public Broker(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
        this.orderHistory = new Stack<>(); 
    }

    public String getName() {
        return name;
    }

    // method to take various orders fro buying or selling stock
    public void takeOrder(Command command) {
        orders.add(command);
    }

    // method to complete the orders present in order list
    public void completeOrders() {
        for(Command order : orders) {
            order.execute();
            orderHistory.push(order); // push for undo
        }
        orders.clear();
    }

    // method to undo the last orders present in order list
    public void undoLastOrder() {
        if (!orderHistory.isEmpty()) {
            Command order = orderHistory.pop();
            order.undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}
