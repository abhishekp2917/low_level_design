package BehaviouralPattern.StatePattern.example2.Solution;

/* 
    ProcessingState class which has all the behaviour that entrance gate can have and 
    each behaviour behaves based on the processing state of the gate
*/
public class ProcessingState implements EntranceGateState {

    private EntranceGate entranceGate;

    public ProcessingState(EntranceGate entranceGate) {
        this.entranceGate = entranceGate;
    }

    // entrance gate behaviour when payment fails when gate is processing
    @Override
    public void paymentFailed() {
        System.out.println(">> Transaction failed! Please try again.\n");
        entranceGate.setCurrentState(new ClosedState(entranceGate));
    }

    // entrance gate behaviour on successfull payment when gate is processing
    @Override
    public void paymentSuccessfull() {
        System.out.println(">> Transaction successfull! You can enter now.\n");
        entranceGate.setCurrentState(new OpenedState(entranceGate));
    }

    // entrance gate behaviour when someone pays the amount when gate is processing
    @Override
    public void payAmount() {
        System.out.println(">> Previous transaction is in process. Please wait till its completed.\n");
    }
    
    // entrance gate behaviour when someone enters the other side of the gate when gate is processing.
    @Override
    public void entered() {
        System.out.println(">> Your transaction has not processed yet. Please wait!\n");
    } 
}
