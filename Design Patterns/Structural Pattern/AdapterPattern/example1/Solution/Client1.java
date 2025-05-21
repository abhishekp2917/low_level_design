package StructuralPattern.AdapterPattern.example1.Solution;


public class Client1 {
    
    public static void main(String[] args) {
        
        // creating first Assignment object  
        Assignment assinment1 = new Assignment("MicroProcessor", "Types of MicroProcessor");

        // writing the assignment with pen
        assinment1.writeAssignment(new BallPen());

        // creating second Assignment object  
        Assignment assinment2 = new Assignment("BlackHole", "Event Horizon");

        // writing the assignment with pen usigning content of PDF
        assinment2.writeAssignment(new PenAdapter());
    }
}
