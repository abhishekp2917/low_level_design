package BehaviouralPattern.MementoPattern.example2.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating a photo
        Photo potrait = new Photo(200, 150);

        // creating photo editor
        PhotoEditor adobe = new PhotoEditor();

        // uploading photo to photo editor
        adobe.uploadPhoto(potrait);

        // editing uploaded photo
        adobe.crop(100, 50.5);
        adobe.increaseBrightness(15);
        adobe.decreaseContrast(10);

        // displaying edited photo
        adobe.display();

        // undoing previous operations
        adobe.undo();
        adobe.undo();

        // editing the photo again
        adobe.increaseContrast(30);
        adobe.decreaseBrightness(25);

        // displaying edited photo
        adobe.display();
    }
}