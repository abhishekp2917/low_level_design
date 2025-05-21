package BehaviouralPattern.CommandPattern.example2.Solution;

/* 
    SellStock class which will be used to sell a particular stock by broker
*/
public class SellStock implements Command{

    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    // execute method which wil sell the stock
    @Override
    public void execute() {
        this.stock.sell();
    }    
}
