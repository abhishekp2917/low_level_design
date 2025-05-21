package StructuralPattern.BridgePattern.example1.problem;

public class Client1 {
    
    public static void main(String[] args) {
        
        View bookLongView = new BookLongView(768, 1080, "Stalin K", "Journey in the East");

        View songShortView = new SongShortView(100, 576, "Arijit Singh");

        View artistShortView = new ArtistShortView(768, 1960, "Justin Bieber");

        bookLongView.show();

        System.out.println();

        songShortView.show();

        System.out.println();

        artistShortView.show();
    }
}
