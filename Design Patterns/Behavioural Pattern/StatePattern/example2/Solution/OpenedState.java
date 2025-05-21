package BehaviouralPattern.StatePattern.example2.Solution;

/* 
    OpenedState class which has all the behaviour that entrance gate can have and 
    each behaviour behaves based on the closed state of the gate
*/
public class OpenedState implements EntranceGateState {
    
    private EntranceGate entranceGate;

    public OpenedState(EntranceGate entranceGate) {
        this.entranceGate = entranceGate;
    }

    // entrance gate behaviour when payment fails when gate is opened
    @Override
    public void paymentFailed() {
        System.out.println(">> Previous payment transaction failed.\n");
    }

    // entrance gate behaviour on successfull payment when gate is opened
    @Override
    public void paymentSuccessfull() {
        System.out.println(">> Previous payment transaction successfull! Your amount will be refunded.\n");
    }

    // entrance gate behaviour when someone pays the amount when gate is opened
    @Override
    public void payAmount() {
        System.out.println(">> Please wait for your turn.\n");
    }

    // entrance gate behaviour when someone enters the other side of the gate when gate is opened
    @Override
    public void entered() {
        System.out.println(">> Welcome to bus travells.\n");
        entranceGate.setCurrentState(new ClosedState(entranceGate));
    } 
}
