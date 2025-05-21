package StructuralPattern.AdapterPattern.example1.Solution;

/* 
    BallPointPen class which extends Pen interface
*/
public class BallPen implements Pen {

    /* 
        write method writes with ballpoint pen
    */
    @Override
    public void write() {
        System.out.println("\nWriting the assignment...\n"); 
    }
}
