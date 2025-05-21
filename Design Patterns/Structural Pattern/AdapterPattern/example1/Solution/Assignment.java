package StructuralPattern.AdapterPattern.example1.Solution;

public class Assignment {
    
    private String title;
    private String topic;

    Assignment(String title, String topic) {
        this.title = title;
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public void writeAssignment(Pen p) {
        p.write();
    }
}
