package StructuralPattern.BridgePattern.example1.solution;

public class Cient1 {
    
    public static void main(String[] args) {
        
        View bookLongView = new LongView(768, 1080, true, new Book("Stalin K", "Journey in the East"));

        View songShortView = new ShortView(100, 576, true, new Song("Arijit Singh", "Pal"));

        View filmShortView = new ShortView(768, 1960, true, new Film("Bahubali 2", "Action"));

        bookLongView.show();

        System.out.println();

        songShortView.show();

        System.out.println();

        filmShortView.show();
    }
}
