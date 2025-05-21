package CreationalPattern.PrototypePattern.example1;

public class Client1 {
    
    public static void main(String[] args) throws CloneNotSupportedException{
        
        // creating a BookShop object and assigning it to variable name 'shop1'
        BookShop shop1 = new BookShop();

        // setting the name of shop1
        shop1.setShopName("Flying Colours");

        /*  loading books from the database to shop which will
            take time as the data is in remote server
        */
        shop1.loadBooks();

        /*  cloning the Bookshop object from previously created object which will
            save time as for creating this object we don't need to fetch data from
            the database again, instead we are copying data from the previous object

            Cloning must be done after books data have been loaded into BookShop 
            object which will use to clone new BooksShop object 
        */
        BookShop shop2 = shop1.clone();

        // setting the name of shop2
        shop2.setShopName("Barclays");


        /*  removing some books from shop1 but it won't affect shop2 as shop2
            is deep cloned object
        */
        shop1.getBooks().remove(1);

        // printing both the shop object
        System.out.println(shop1);
        System.out.println(shop2);
    }
}
