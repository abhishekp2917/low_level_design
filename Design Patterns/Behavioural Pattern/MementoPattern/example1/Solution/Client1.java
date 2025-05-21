package BehaviouralPattern.MementoPattern.example1.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating text editor 
        TextEditor vscode = new TextEditor();

        // writing on textarea using text editor
        vscode.write("Hello world! ");
        vscode.write("This is Abhishek here. ");
        vscode.write("Hope you all are doing great. ");

        // displaying text of textarea
        vscode.display();

        // undoing textarea
        vscode.undo();

        // displaying updated text of textarea 
        vscode.display();

        // writing text on text area using text editor
        vscode.write("I hope everything is fine there. ");

        // displaying updated text of textarea 
        vscode.display();
    }
}
