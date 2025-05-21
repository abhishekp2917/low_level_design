package BehaviouralPattern.MementoPattern.example2.Solution;


/* 
    Photo class which represents photo that is to be edited
*/
public class Photo {

    private double brightness = 50.0, contrast = 50.0, saturation = 50.0;
    private double height, width;

    public Photo(double height, double width) {
        this.height = height;
        this.width = width;
    }

    // method to set brightness 
    public void setBrightness(double brightness) {
        if(brightness>100) this.brightness = 100.0;
        else if(brightness<0) this.brightness = 0.0;
        else this.brightness = brightness;
    }

    // method to set constrast
    public void setContrast(double contrast) {
        if(brightness>100) this.contrast = 100.0;
        else if(brightness<0) this.contrast = 0.0;
        else this.contrast = contrast;
        
    }

    // method to set saturation
    public void setSaturation(double saturation) {
        if(saturation>100) this.saturation = 100.0;
        else if(saturation<0) this.saturation = 0.0;
        else this.saturation = saturation;
    }

    // method to set height
    public void setHeight(double height) {
        this.height = height;
    }

    // method to set width
    public void setWidth(double width) {
        this.width = width;
    }

    public double getBrightness() {
        return brightness;
    }

    public double getContrast() {
        return contrast;
    }

    public double getSaturation() {
        return saturation;
    }

    // method to get snapshot of current photo state
    public PhotoSnapshot getSnapshot() {
        return new PhotoSnapshot(this.brightness, this.contrast, this.saturation, this.height, this.width);
    }

    // emthod to show photo in current state
    public void show() {
        System.out.println("Height : " + this.height);
        System.out.println("Width : " + this.width);
        System.out.println("Brightness : " + this.brightness);
        System.out.println("Contrast : " + this.contrast);
        System.out.println("Saturation : " + this.saturation);
        System.out.println();
    }


    /* 
        PhotoSnapshot class which will be used to store current state of the 
        photo object which can be used to restore later on
    */
    public static class PhotoSnapshot {
        private final double brightness, contrast, saturation;
        private final double height, width;

        public PhotoSnapshot(double brightness, double contrast, double saturation, double height, double width) {
            this.brightness = brightness;
            this.contrast = contrast;
            this.saturation = saturation;
            this.height = height;
            this.width = width;
        }

        public double getBrightness() {
            return brightness;
        }

        public double getContrast() {
            return contrast;
        }

        public double getSaturation() {
            return saturation;
        }

        public double getHeight() {
            return height;
        }

        public double getWidth() {
            return width;
        }
    } 
}
