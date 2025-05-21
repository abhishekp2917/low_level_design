package BehaviouralPattern.CommandPattern.example2.Solution;

import java.util.ArrayList;
import java.util.List;

/* 
    Broker is an invoker class which will use Command objects to execute various
    commands like SellStock to sell the stock and BuyStock to buy the stock
*/
public class Broker {
    
    private String name;
    private List<Command> orders = new ArrayList<>();

    public Broker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // method to take various orders fro buying or selling stock
    public void takeOrders(Command command) {
        orders.add(command);
    }

    // method to complete the orders present in order list
    public void completeOrders() {
        for(Command order : orders) {
            order.execute();
        }
        orders.clear();
    }
}
