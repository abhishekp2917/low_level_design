/**
 * HasPinState is a Concrete State in the State Design Pattern.
 *
 * This state represents the ATM after a card has been inserted and the correct PIN has been entered.
 * It handles actions appropriate to this authenticated state.
 */
public class HasPinState extends ATMState {

    public HasPinState(ATMMachine atmMachine) {
        super(atmMachine);
    }

    /**
     * Called when user attempts to insert a card after entering PIN.
     * Action: Deny the operation since a transaction is already underway.
     */
    @Override
    public void insertCard() {
        System.out.println(">> Previous transaction is pending. Please wait!");
    }

    /**
     * Called when user chooses to eject the card after entering PIN.
     * Action: Eject the card and reset to NoCardState.
     */
    @Override
    public void ejectCard() {
        System.out.println(">> Card ejected.");
        atmMachine.setCurrentState(atmMachine.getNoCardState());
    }

    /**
     * Called when user tries to re-enter the PIN.
     * Action: Not allowed as PIN is already validated.
     */
    @Override
    public void enterPIN(int enteredPIN) {
        System.out.println(">> Previous transaction is pending. Please wait!");
    }

    /**
     * Called when user requests to withdraw cash.
     * Action:
     * - If sufficient cash is available: dispense it and update the ATM's cash.
     *   - If cash becomes 0: transition to NoCashState.
     *   - Otherwise: transition to NoCardState (transaction complete).
     * - If insufficient cash: reject request and reset to NoCardState.
     */
    @Override
    public void requestCash(int cashAmount) {
        if (cashAmount <= atmMachine.getCashInMachine()) {
            System.out.println(">> " + cashAmount + " has been withdrawn from your account\n");
            atmMachine.setCashInMachine(atmMachine.getCashInMachine() - cashAmount);

            if (atmMachine.getCashInMachine() == 0) {
                atmMachine.setCurrentState(atmMachine.getNoCashState());
            } else {
                atmMachine.setCurrentState(atmMachine.getNoCardState());
            }
        } else {
            System.out.println(">> Inadequate cash in ATM. Sorry for inconvenience\n");
            atmMachine.setCurrentState(atmMachine.getNoCardState());
        }
    }
}
