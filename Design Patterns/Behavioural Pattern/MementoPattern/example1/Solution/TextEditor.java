package BehaviouralPattern.MementoPattern.example1.Solution;

import java.util.ArrayList;
import java.util.List;
import BehaviouralPattern.MementoPattern.example1.Solution.TextArea.TextMemento;


/* 
    text editor class which will be used to edit text and have feature of undoing 
    as well
*/
public class TextEditor {
    
    // textarea which wil be used to write on
    private TextArea textArea = new TextArea();
    // snapshots to store snapshot of past text versions
    private List<TextMemento> snapshots = new ArrayList<>();

    // method to write text on textarea
    public void write(String newText) {
        textArea.addText(newText);
        snapshots.add(textArea.takeSnapshot());
    }

    // method to do undo textarea
    public void undo() {
        if(!snapshots.isEmpty()) {
            snapshots.remove(snapshots.size()-1);

            TextMemento snapshot = snapshots.get(snapshots.size()-1);

            textArea.setText(snapshot.getText());
            textArea.setBold(snapshot.getBold());
            textArea.setItalic(snapshot.getItalic());
            textArea.setUnderline(snapshot.getUnderline());
        }
    }

    // method to display text of textarea
    public void display() {
        textArea.show();
    }
}