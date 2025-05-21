package CreationalPattern.BuilderPattern.example1;


/* 
    PhoneBuilder class is responsible to create Phone class object and based on 
    what setter methods are called, it will set the attribute values and at last
    will return Phone class object
*/
public class PhoneBuilder {

    /*  PhoneBuilder class has attributes similar to Phone class and this attributes
        will be used to create Phone object and initialize Phone object 
    */
    private String brand;
    private String processor;
    private double screenSize;
    private int RAMSize;
    private int storageSize;

    /*  all the setter methods return this class object so that it can be use to call 
        another setter methods
    */
    public PhoneBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setRAMSize(int RAMSize) {
        this.RAMSize = RAMSize;
        return this;
    }

    public PhoneBuilder setStorageSize(int storageSize) {
        this.storageSize = storageSize;
        return this;
    }

    /*  This method will create Phone object and to initialize the Phone object
        attributes, this class attributes will be used
    */
    public Phone getPhone(){
        return new Phone(this.brand, this.processor, this.screenSize, this.RAMSize, this.storageSize);
    }
}
