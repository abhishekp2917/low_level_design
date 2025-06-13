package BehaviouralPattern.StatePattern.example1.Solution;

/**
 * NoCashState is a Concrete State in the State Design Pattern.
 *
 * This state represents the condition where the ATM has run out of cash.
 * All operations related to transactions are blocked in this state.
 */
public class NoCashState implements ATMState {

    public NoCashState(ATMMachine atmMachine) {
        super(atmMachine);
    }

    /**
     * Called when user attempts to insert a card.
     * Action: Denied because ATM cannot perform any transactions due to lack of cash.
     */
    @Override
    public void insertCard() {
        System.out.println(">> No cash in ATM. Sorry for inconvenience.\n");
    }

    /**
     * Called when user attempts to eject a card.
     * Action: Denied because no card was inserted (typically ATM won't accept card in this state).
     */
    @Override
    public void ejectCard() {
        System.out.println(">> Card not inserted. Please enter a card first.\n");
    }

    /**
     * Called when user attempts to enter a PIN.
     * Action: Denied because no card is inserted, and ATM can't proceed without cash.
     */
    @Override
    public void enterPIN(int enteredPIN) {
        System.out.println(">> Card not inserted. Please enter a card first.\n");
    }

    /**
     * Called when user requests a cash withdrawal.
     * Action: Denied as no card is inserted and ATM is out of service for withdrawals.
     */
    @Override
    public void requestCash(int cashAmount) {
        System.out.println(">> Card not inserted. Please enter a card first.\n");
    }
}
