package BehaviouralPattern.StatePattern.example2.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating entrance gate 
        EntranceGate busTerminalGate = new EntranceGate();
        
        System.out.println("Paying amount to enter :");
        busTerminalGate.payAmount();

        busTerminalGate.paymentSuccessfull();

        System.out.println("Entered on the other side of the gate :");
        busTerminalGate.entered();

        System.out.println("Entered without paying amount :");
        busTerminalGate.entered();

        System.out.println("Paying amount to enter :");
        busTerminalGate.payAmount();

        System.out.println("Entered before completion of the transaction :");
        busTerminalGate.entered();

        busTerminalGate.paymentFailed();
    }
}
