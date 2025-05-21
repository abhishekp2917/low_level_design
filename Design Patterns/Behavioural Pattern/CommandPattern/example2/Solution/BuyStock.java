package BehaviouralPattern.CommandPattern.example2.Solution;

/* 
    SellStock class which will be used to buy a particular stock by broker
*/
public class BuyStock implements Command{

    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    // execute method which wil buy the stock
    @Override
    public void execute() {
        this.stock.buy();
    }    
}