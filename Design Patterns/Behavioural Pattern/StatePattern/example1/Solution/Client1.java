package BehaviouralPattern.StatePattern.example1.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        ATMMachine sbiATM = new ATMMachine(3000);

        sbiATM.insertCard();

        sbiATM.ejectCard();

        sbiATM.enterPIN(1234);

        sbiATM.requestCash(1500);

        sbiATM.requestCash(1500);

        sbiATM.insertCard();

        sbiATM.enterPIN(1234);

        sbiATM.requestCash(2000);
    }
}
