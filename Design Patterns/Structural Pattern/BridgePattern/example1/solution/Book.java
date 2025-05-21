package StructuralPattern.BridgePattern.example1.solution;


/* 
    creating Book resource to show it in different views
*/
public class Book implements Resource{
    
    private String author;
    private String title;

    Book(String author, String title) {
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

    /*
        overriding intro method to show Book intro 
    */
    @Override
    public void intro() {
        System.out.println("Book Title : " + this.title);
    }

    /*
        overriding intro method to show Book description 
    */
    @Override
    public void description() {
        System.out.println("Author : " + this.author);
    }
}
