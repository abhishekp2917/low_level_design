package StructuralPattern.BridgePattern.example1.problem;


public class BookLongView extends View{

    private String author;
    private String title;

    BookLongView(int viewHeight, int viewWidth, String author, String title) {
        super(viewHeight, viewWidth, true);
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void show() {
        System.out.println("Showing Long view \nAuthor : " + this.getAuthor() + "\nBook Title : " + this.getTitle());
    }

    @Override
    public void hide() {
        System.out.println("Hiding Long view \nAuthor : " + this.getAuthor() + "\nBook Title : " + this.getTitle());
    }
}