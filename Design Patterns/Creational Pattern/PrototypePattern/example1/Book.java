package CreationalPattern.PrototypePattern.example1;


public class Book {

    private int bookId;
    private String author;
    private int pages;

    Book(int bookId, String author, int pages) {
        this.bookId = bookId;
        this.author = author;
        this.pages = pages;
    }

    public void setBookid(int bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "[" + Integer.toString(bookId) + ", " + author + ", " + Integer.toString(pages) + "]";
    }
}
