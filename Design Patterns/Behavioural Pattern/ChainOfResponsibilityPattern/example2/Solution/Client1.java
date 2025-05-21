package BehaviouralPattern.ChainOfResponsibilityPattern.example2.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating candidates 
        Candidate abhishek = new Candidate("Abhishek", 70, 80, 1);
        Candidate shivam = new Candidate("Shivam", 50, 80, 3);
        Candidate saurabh = new Candidate("Saurabh", 74, 80, 2);

        // creating panel
        Panel SDEPanel = new Panel();

        // panel conducting various rounds of each candidate
        SDEPanel.hire(abhishek);
        SDEPanel.hire(shivam);
        SDEPanel.hire(saurabh);
    }
}
