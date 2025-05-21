package BehaviouralPattern.MementoPattern.example2.Solution;

import java.util.ArrayList;
import java.util.List;
import BehaviouralPattern.MementoPattern.example2.Solution.Photo.PhotoSnapshot;


/* 
    PhotoEditor class which will be used to edit photo such as changing brightness,
    contrast and croping photo
*/
public class PhotoEditor {
    
    private Photo photo;
    private List<PhotoSnapshot> photoSnapshots = new ArrayList<>();

    // method to upload photo to photo editor
    public void uploadPhoto(Photo photo) {
        this.photo = photo;
    }

    // method to increase brightness of uploaded photo
    public void increaseBrightness(double incrementValue) {
        photo.setBrightness(photo.getBrightness()+incrementValue);
        photoSnapshots.add(photo.getSnapshot());
    }

    // method to decrease brightness of uploaded photo
    public void decreaseBrightness(double decrementValue) {
        photo.setBrightness(photo.getBrightness()-decrementValue);
        photoSnapshots.add(photo.getSnapshot());
    }

    // method to increase contrast of uploaded photo
    public void increaseContrast(double incrementValue) {
        photo.setContrast(photo.getBrightness()+incrementValue);
        photoSnapshots.add(photo.getSnapshot());
    }

    // method to decrease contrast of uploaded photo
    public void decreaseContrast(double decrementValue) {
        photo.setContrast(photo.getBrightness()-decrementValue);
        photoSnapshots.add(photo.getSnapshot());
    }

    // method to crop uploaded photo
    public void crop(double height, double width) {
        photo.setHeight(height);
        photo.setWidth(width);
        photoSnapshots.add(photo.getSnapshot());
    }

    // method to do undo operation
    public void undo() {
        if(photoSnapshots.size()>1){
            photoSnapshots.remove(photoSnapshots.size()-1);
            PhotoSnapshot snapshot = photoSnapshots.get(photoSnapshots.size()-1);
            photo.setBrightness(snapshot.getBrightness());
            photo.setContrast(snapshot.getContrast());
            photo.setSaturation(snapshot.getSaturation());
            photo.setHeight(snapshot.getHeight());
            photo.setWidth(snapshot.getWidth());
        }
    }

    // method to display photo 
    public void display() {
        photo.show();
    }
}
