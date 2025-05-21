package BehaviouralPattern.StatePattern.example1.Solution;

public class ATMMachine {

    private NoCardState noCardState;
    private HasCardState hasCardState;
    private HasPinState hasPinState;
    private NoCashState noCashState;
    private ATMState currentState;

    private int cashInMachine;

    public ATMMachine(int cashInMachine) {
        this.cashInMachine = cashInMachine;
        this.noCardState = new NoCardState(this);
        this.hasCardState = new HasCardState(this);
        this.hasPinState = new HasPinState(this);
        this.noCashState = new NoCashState(this);
        currentState = this.noCardState;
        if(this.cashInMachine==0) currentState = this.noCashState;
    }

    public NoCardState getNoCardState() {
        return noCardState;
    }

    public HasCardState getHasCardState() {
        return hasCardState;
    }

    public HasPinState getHasPinState() {
        return hasPinState;
    }

    public NoCashState getNoCashState() {
        return noCashState;
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public int getCashInMachine() {
        return cashInMachine;
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public void setCashInMachine(int cashInMachine) {
        this.cashInMachine = cashInMachine;
    }

    public void insertCard() {
        currentState.insertCard();
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void enterPIN(int enteredPIN) {
        currentState.enterPIN(enteredPIN);
    }

    public void requestCash(int cashAmount) {
        currentState.requestCash(cashAmount);
    }
}
