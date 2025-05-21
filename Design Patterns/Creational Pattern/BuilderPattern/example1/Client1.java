package CreationalPattern.BuilderPattern.example1;


public class Client1 {
    
    public static void main(String[] args) {
        
        // creating PhoneBuilder object to build/create Phone class object
        PhoneBuilder builder = new PhoneBuilder();

        /* 
            creating Phone class objects using PhoneBuilder object and initializing
            Phone object attributes using PhoneBuilder setter methods

            Using this PhoneBuilder there is no need to initialize all the attribute
            of Phone object. Moreover, there is no need to remember the order in which
            attribute values to be passed
        */
        Phone phone1 = builder.setBrand("Samsung").setRAMSize(4).setStorageSize(64).getPhone();
        Phone phone2 = builder.setBrand("Realme").setProcessor("Qualcom Snapdragon").setRAMSize(8).getPhone();

        // printing phone object
        System.out.println(phone1);
        System.out.println(phone2);
    }
}
