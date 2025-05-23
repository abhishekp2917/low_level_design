public class Cient1 {
    
    public static void main(String[] args) {
        
        View bookLongView = new LongView(768, 1080, new Book("Stalin K", "Journey in the East"));

        View songShortView = new ShortView(100, 576, new Song("Arijit Singh", "Pal"));

        bookLongView.show();

        System.out.println();

        songShortView.show();

    }
}
