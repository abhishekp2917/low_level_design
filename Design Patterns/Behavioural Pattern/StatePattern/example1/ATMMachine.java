package BehaviouralPattern.StatePattern.example1.Solution;

/**
 * ATMMachine acts as the Context in the State Design Pattern.
 *
 * - It holds a reference to the current state.
 * - It defines all possible states as separate objects.
 * - It delegates operations to the current state.
 *
 * The state objects handle behavior associated with the current state,
 * and they can transition the ATM to a new state by updating the context's state reference.
 */
public class ATMMachine {

    // =================== All possible state instances ===================

    private ATMState noCardState;
    private ATMState hasCardState;
    private ATMState hasPinState;
    private ATMState noCashState;

    // This is the actual state the ATM is currently in
    private ATMState currentState;

    // Represents how much cash is available in the ATM
    private int cashInMachine;

    /**
     * Constructor initializes ATM with given cash and sets up all states.
     * Each state receives a reference to this context object for state transitions.
     */
    public ATMMachine(int cashInMachine) {
        this.cashInMachine = cashInMachine;

        // Instantiate all concrete states, passing this ATM context
        this.noCardState = new NoCardState(this);
        this.hasCardState = new HasCardState(this);
        this.hasPinState = new HasPinState(this);
        this.noCashState = new NoCashState(this);

        // Set the initial state of the machine based on cash availability
        this.currentState = (cashInMachine == 0) ? this.noCashState : this.noCardState;
    }

    // These getters are used by the current state to transition to other states
    public ATMState getNoCardState() {
        return noCardState;
    }

    public ATMState getCardInsertedState() {
        return hasCardState;
    }

    public ATMState getHasPINState() {
        return hasPinState;
    }

    public ATMState getNoCashState() {
        return noCashState;
    }

    // Getter & Setter for current state
    public ATMState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public int getCashInMachine() {
        return cashInMachine;
    }

    public void setCashInMachine(int cashInMachine) {
        this.cashInMachine = cashInMachine;
    }

    // =================== Public actions available to users ===================
    // These actions are delegated to the current state implementation

    /**
     * User attempts to insert a card.
     * Actual handling is delegated to the current state object.
     */
    public void insertCard() {
        currentState.insertCard();
    }

    /**
     * User attempts to eject the card.
     * Actual handling is delegated to the current state object.
     */
    public void ejectCard() {
        currentState.ejectCard();
    }

    /**
     * User enters a PIN.
     * Actual handling is delegated to the current state object.
     */
    public void enterPIN(int enteredPIN) {
        currentState.enterPIN(enteredPIN);
    }

    /**
     * User requests a certain amount of cash.
     * Actual handling is delegated to the current state object.
     */
    public void requestCash(int cashAmount) {
        currentState.requestCash(cashAmount);
    }
}
