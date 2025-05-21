package BehaviouralPattern.MementoPattern.example1.Solution;


/* 
    textarea which is used by the textarea to write on
*/
public class TextArea {
    
    private String text = "";
    private boolean bold;
    private boolean italic;
    private boolean underline;

    public void setText(String text) {
        this.text = text;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public void setUnderline(boolean underline) {
        this.underline = underline;
    }

    // method to add text in textarea
    public void addText(String newText) {
        this.text += newText;
    }

    // method to takesnapshot of text area by creating memento object
    public TextMemento takeSnapshot() {
        return new TextMemento(this.text, this.bold, this.italic, this.underline);
    }

    // method to show current status of textarea
    public void show() {
        System.out.println("Text : " + this.text);
        System.out.println("Bold : " + Boolean.toString(this.bold));
        System.out.println("Italic : " + Boolean.toString(this.italic));
        System.out.println("Underline : " + Boolean.toString(this.underline) + "\n");
    }

    /* 
        TextMemento class which will be used to clone attributes value of textarea 
        and whose object will be used as a snapshot 
    */
    public class TextMemento {

        private final String text;
        private final boolean bold;
        private final boolean italic;
        private final boolean underline;

        private TextMemento(String text, boolean bold, boolean italic, boolean underline) {
            this.text = text;
            this.bold = bold;
            this.italic = italic;
            this.underline = underline;
        }

        public String getText() {
            return this.text;
        }

        public boolean getBold() {
            return this.bold;
        }

        public boolean getItalic() {
            return this.italic;
        }

        public boolean getUnderline() {
            return this.underline;
        }
    }
}
