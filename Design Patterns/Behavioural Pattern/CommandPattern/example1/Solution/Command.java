package BehaviouralPattern.CommandPattern.example1.Solution;

/* 
    Command interface which have two methods one to execute the command and another one 
    is to do totally opposite of execute
*/
public interface Command {
    
    // abstract method to execute
    public void execute();

    // method to unexecute or undo operation
    public void unexecute();
}
