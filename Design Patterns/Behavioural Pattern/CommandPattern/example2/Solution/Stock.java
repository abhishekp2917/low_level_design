package BehaviouralPattern.CommandPattern.example2.Solution;

/* 
    Stock class which have info about particular stock which can be bought and sold 
*/
public class Stock {
    
    private String companyName;
    private double price;

    public Stock(String companyName, double price) {
        this.companyName = companyName;
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getPrice() {
        return price;
    }

    // method to buy the stock
    public void buy() {
        System.out.println("Buying stock of " + this.companyName + " company of value " + Double.toString(this.price));
    }

    // method to sell the stock
    public void sell() {
        System.out.println("Selling stock of " + this.companyName + " company of value " + Double.toString(this.price));
    }
}
