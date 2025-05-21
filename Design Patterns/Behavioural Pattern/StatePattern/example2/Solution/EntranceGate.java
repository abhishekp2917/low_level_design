package BehaviouralPattern.StatePattern.example2.Solution;

/* 
    EntranceGate class which possess multiple states and chnages its behaviour in 
    different state
*/
public class EntranceGate {

    private EntranceGateState currentState;

    public EntranceGate() {
        this.currentState = new ClosedState(this);
    }

    // method to set current state
    public void setCurrentState(EntranceGateState currentState) {
        this.currentState = currentState;
    }

    // entrance gate behaviour when payment fails
    public void paymentFailed() {
        currentState.paymentFailed();
    }

    // entrance gate behaviour on successfull payment
    public void paymentSuccessfull() {
        currentState.paymentSuccessfull();
    }

    // entrance gate behaviour when someone pays the amount
    public void payAmount() {
        currentState.payAmount();
    }

    // entrance gate behaviour when someone enters the other side of the gate
    public void entered() {
        currentState.entered();
    }
}
