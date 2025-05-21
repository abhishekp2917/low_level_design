package BehaviouralPattern.StatePattern.example1.Solution;

public class HasCardState implements ATMState{

    private ATMMachine atmMachine;

    public HasCardState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println(">> Card already inserted.\n");
    }

    @Override
    public void ejectCard() {
        System.out.println(">> Card ejected.\n");
    }

    @Override
    public void enterPIN(int enteredPIN) {
        if(enteredPIN==1234) {
            System.out.println(">> Correct PIN entered. Welcome to your account\n");
            atmMachine.setCurrentState(atmMachine.getHasPinState());
        }
        else {
            System.out.println(">> Incorrect PIN entered. Please try again\n");
            atmMachine.setCurrentState(atmMachine.getNoCardState());
        }
    }

    @Override
    public void requestCash(int cashAmount) {
        System.out.println(">> Please enter your PIN.");
    }
}
