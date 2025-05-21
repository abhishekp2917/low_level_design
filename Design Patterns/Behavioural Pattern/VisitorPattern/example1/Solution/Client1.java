package BehaviouralPattern.VisitorPattern.example1.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        CreditCard hdfcGoldCard = new GoldCard();
        CreditCard hdfcSilverCard = new SilverCard();
    }
}
