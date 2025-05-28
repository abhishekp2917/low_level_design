public interface Command {
    
    void execute(); // perform the command
    void undo();    // revert the command
}
