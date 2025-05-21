package BehaviouralPattern.StatePattern.example1.Solution;

public interface ATMState {
    
    public void insertCard();

    public void ejectCard();

    public void enterPIN(int enteredPIN);

    public void requestCash(int cashAmount);
}
