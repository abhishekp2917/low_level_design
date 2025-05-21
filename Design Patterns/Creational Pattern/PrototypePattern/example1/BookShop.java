package CreationalPattern.PrototypePattern.example1;

import java.util.ArrayList;
import java.util.List;

/*
    creating BookShop class which will be use to create Book objects
*/
public class BookShop implements Cloneable{
    
    private String shopName;
    private List<Book> books = new ArrayList<> ();

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getShopName() {
        return shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    /*  mimicing method to fetch data from database about books and loading it into
        BookShop object
    */
    public void loadBooks() {

        for (int i=1; i<=10; i++) {

            // fetch data from database
            int id = i;
            String authorName = "Author"+Integer.toString(i);
            int pages = 100;

            // creating and adding Book object into books list 
            books.add(new Book(id, authorName, pages));
        }
    }

    /*
        overriding clone method of class Object 
        This method will create a deep clone of Bookshop object and will return it 
    */
    @Override
    public BookShop clone() {

        // creating BookShop object
        BookShop shop = new BookShop();

        // copying books data from current object 
        for(Book b: this.getBooks()){
            shop.getBooks().add(b);
        }
        
        // returning BookShop object which was deep clonesd
        return shop;
    }

    @Override
    public String toString() {
        return "Bookshop [shopname=" + "'" + shopName + "'" + ", books=" + books + "]";
    }
}
