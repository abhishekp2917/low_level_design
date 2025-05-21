package BehaviouralPattern.StatePattern.example2.Solution;

/* 
    ClosedState class which has all the behaviour that entrance gate can have and 
    each behaviour behaves based on the closed state of the gate
*/
public class ClosedState implements EntranceGateState {
    
    private EntranceGate entranceGate;

    public ClosedState(EntranceGate entranceGate) {
        this.entranceGate = entranceGate;
    }

    // entrance gate behaviour when payment fails when gate is closed
    @Override
    public void paymentFailed() {
        System.out.println(">> Previous payment transaction failed.\n");
    }

    // entrance gate behaviour on successfull payment when gate is closed
    @Override
    public void paymentSuccessfull() {
        System.out.println(">> Previous payment transaction successfull.");
        System.out.println(">> Amount will be refunded.\n");
    }

    // entrance gate behaviour when someone pays the amount when gate is closed
    @Override
    public void payAmount() {
        System.out.println(">> Processing your payment. Please wait!\n");
        entranceGate.setCurrentState(new ProcessingState(entranceGate));
    } 

    // entrance gate behaviour when someone enters the other side of the gate when gate is closed
    @Override
    public void entered() {
        System.out.println(">> Please pay to enter.\n");
    } 
}
