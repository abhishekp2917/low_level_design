package CreationalPattern.BuilderPattern.example1;

public class Phone {
    
    private String brand;
    private String processor;
    private double screenSize;
    private int RAMSize;
    private int storageSize;

    Phone(String brand, String processor, double screenSize, int RAMSize, int storageSize) {
        this.brand = brand;
        this.processor = processor;
        this.screenSize = screenSize;
        this.RAMSize = RAMSize;
        this.storageSize = storageSize;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public void setRAMSize(int rAMSize) {
        RAMSize = rAMSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public String getBrand() {
        return brand;
    }

    public String getProcessor() {
        return processor;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getRAMSize() {
        return RAMSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    @Override
    public String toString() {
        return "[" + "brand=" + this.brand + ", processor=" + this.processor + ", screenSize=" + this.screenSize + ", RAMSize=" + this.RAMSize + ", storageSize=" + this.storageSize + "]";
    }

}
