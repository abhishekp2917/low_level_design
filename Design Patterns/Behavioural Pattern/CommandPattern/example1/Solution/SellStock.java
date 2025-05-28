/* 
    SellStock class which will be used to sell a particular stock by broker
*/
public class SellStock implements Command{

    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    // execute method which will sell the stock
    @Override
    public void execute() {
        this.stock.sell();
    }  
    
    // execute method which will undo i.e. buy the stock
    @Override
    public void undo() {
        this.stock.buy();
    }  
}
