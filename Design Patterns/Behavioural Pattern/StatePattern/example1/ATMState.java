/**
 * ATMState is the Abstract State in the State Design Pattern.
 *
 * It defines the common abstract methods for all possible ATM states.
 * Each concrete state (e.g., NoCardState, HasCardState) will extend this class
 * and implement its own behavior for each user action.
 *
 * It also holds a protected reference to the Context (ATMMachine),
 * enabling concrete states to:
 * - Change the current state of the ATM (i.e., state transition)
 * - Access or modify shared data like cash in the machine
 */
public abstract class ATMState {

    // This allows the state to trigger transitions and access ATM data
    protected ATMMachine atmMachine;

    /**
     * Constructor receives the context object and stores a reference.
     * This is essential for state transitions and logic based on ATM state.
     */
    public ATMState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    // =================== State-Specific Behavior ===================
    // These are the user actions on Context (ATMMachine) that states must handle differently.

   
    public abstract void insertCard();

    public abstract void ejectCard();

    public abstract void enterPIN(int enteredPIN);

    public abstract void requestCash(int cashAmount);
}
