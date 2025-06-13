/**
 * NoCardState is a Concrete State in the State Design Pattern.
 *
 * This state represents the ATM when no card has been inserted.
 * It defines how the ATM should behave for each user action while in this state.
 */
public class NoCardState extends ATMState {

    public NoCardState(ATMMachine atmMachine) {
        super(atmMachine);
    }

    /**
     * Called when the user inserts a card.
     * Action: Accept the card and transition to HasCardState.
     */
    @Override
    public void insertCard() {
        System.out.println(">> Card inserted. Please enter pin.\n");
        // Transition to the next appropriate state (HasCardState)
        atmMachine.setCurrentState(atmMachine.getCardInsertedState());
    }

    /**
     * Called when the user tries to eject the card.
     * Action: Invalid action in this state (no card inserted).
     */
    @Override
    public void ejectCard() {
        System.out.println(">> Card not inserted. Please enter a card first.\n");
    }

    /**
     * Called when the user tries to enter a PIN.
     * Action: Invalid, since there's no card in the machine.
     */
    @Override
    public void enterPIN(int enteredPIN) {
        System.out.println(">> Card not inserted. Please enter a card first.\n");
    }

    /**
     * Called when the user requests cash.
     * Action: Invalid, since the machine has no card to identify user/account.
     */
    @Override
    public void requestCash(int cashAmount) {
        System.out.println(">> Card not inserted. Please enter a card first.\n");
    }
}
