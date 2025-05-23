package StructuralPattern.BridgePattern.example1.problem;

public class BookShortView extends View{
    
    private String author;

    BookShortView(int viewHeight, int viewWidth, String author) {
        super(viewHeight, viewWidth, true);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void show() {
        System.out.println("Showing Short view \nAuthor : " + this.getAuthor());
    }
}
