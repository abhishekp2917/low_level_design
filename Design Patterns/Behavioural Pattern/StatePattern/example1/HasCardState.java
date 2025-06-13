/**
 * HasCardState is a Concrete State in the State Design Pattern.
 *
 * This state represents the ATM when a card has been inserted but PIN is not yet verified.
 * It defines how the ATM should respond to user inputs in this specific state.
 */
public class HasCardState extends ATMState {

    public HasCardState(ATMMachine atmMachine) {
        super(atmMachine);
    }

    /**
     * Called when the user tries to insert a second card.
     * Action: Reject the action since a card is already inserted.
     */
    @Override
    public void insertCard() {
        System.out.println(">> Card already inserted.\n");
    }

    /**
     * Called when the user ejects the card.
     * Action: Accept it and transition back to NoCardState.
     */
    @Override
    public void ejectCard() {
        System.out.println(">> Card ejected.\n");
        atmMachine.setCurrentState(atmMachine.getNoCardState());
    }

    /**
     * Called when the user enters their PIN.
     * Action: Verify the PIN.
     *         If correct, transition to HasPinState.
     *         If incorrect, stay in the current state.
     */
    @Override
    public void enterPIN(int enteredPIN) {
        if (enteredPIN == 1234) {
            System.out.println(">> Correct PIN entered. Welcome to your account\n");
            atmMachine.setCurrentState(atmMachine.getHasPINState());
        } else {
            System.out.println(">> Incorrect PIN entered. Please try again\n");
        }
    }

    /**
     * Called when the user requests cash before entering a PIN.
     * Action: Deny the request and prompt for PIN.
     */
    @Override
    public void requestCash(int cashAmount) {
        System.out.println(">> Please enter your PIN.");
    }
}
