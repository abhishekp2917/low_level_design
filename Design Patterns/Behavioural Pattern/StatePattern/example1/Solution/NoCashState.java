package BehaviouralPattern.StatePattern.example1.Solution;

public class NoCashState implements ATMState {
    
    private ATMMachine atmMachine;

    public NoCashState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    public ATMMachine getAtmMachine() {
        return atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println(">> No cash in ATM. Sorry for inconvinience.\n");
    }

    @Override
    public void ejectCard() {
        System.out.println(">> Card not inserted. Please enter a card first.\n");
    }

    @Override
    public void enterPIN(int enteredPIN) {
        System.out.println(">> Card not inserted. Please enter a card first.\n");
    }

    @Override
    public void requestCash(int cashAmount) {
        System.out.println(">> Card not inserted. Please enter a card first.\n");
    }
}
