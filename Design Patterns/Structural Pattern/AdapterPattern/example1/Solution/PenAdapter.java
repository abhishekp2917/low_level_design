package StructuralPattern.AdapterPattern.example1.Solution;

/* 
    PenAdapter class which acts as ana adapter between pen and pdf
*/
public class PenAdapter implements Pen {

    // creating PDF class objects to access the write method
    private PDF pdf = new PDF();

    // using PDF write method to write the PDF content
    @Override
    public void write() {
        pdf.write();
    }
}
