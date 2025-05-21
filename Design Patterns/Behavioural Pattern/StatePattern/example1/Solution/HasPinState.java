package BehaviouralPattern.StatePattern.example1.Solution;

public class HasPinState implements ATMState {
    
    private ATMMachine atmMachine;

    public HasPinState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println(">> Previous transaction is pending. Please wait!");
    }

    @Override
    public void ejectCard() {
        System.out.println(">> Card ejected.");
    }

    @Override
    public void enterPIN(int enteredPIN) {
        System.out.println(">> Previous transaction is pending. Please wait!");
    }

    @Override
    public void requestCash(int cashAmount) {
        if(cashAmount<=atmMachine.getCashInMachine()) {
            System.out.println(">> " + cashAmount + " has been withdrawn from your account\n");
            atmMachine.setCashInMachine(atmMachine.getCashInMachine()-cashAmount);

            if(atmMachine.getCashInMachine()==0) atmMachine.setCurrentState(atmMachine.getNoCashState());
            else atmMachine.setCurrentState(atmMachine.getNoCardState());
        }
        else {
            System.out.println(">> Inadequate cash in ATM. Sorry for inconvinience\n");
            atmMachine.setCurrentState(atmMachine.getNoCardState());
        }
    }
}
