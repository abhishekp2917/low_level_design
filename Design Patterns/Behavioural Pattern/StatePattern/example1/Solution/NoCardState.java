package BehaviouralPattern.StatePattern.example1.Solution;

public class NoCardState implements ATMState {

    private ATMMachine atmMachine;

    public NoCardState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }
    
    @Override
    public void insertCard() {
        System.out.println(">> Card inserted. Please enter pin.\n");
        atmMachine.setCurrentState(atmMachine.getHasCardState());
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
