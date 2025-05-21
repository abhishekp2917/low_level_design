package CreationalPattern.SingletonPattern;


class Abc{

    /*  Creating 'Abc' (this) class object and assigining it to 
        static variable so that there is no need to create the object of 
        this class to access this variable.

        Moreover, this variable will be accessible inside static getter method
    */
    static Abc s = new Abc();


    /*  declaring class constructor as private so that no object
        can be created from outside of this class 
    */
    private Abc() {

        System.out.println("Object of class Abc created");
    }


    /*  getter method to get this class object and declaring this method
        as static so that there would be no requirement to create object
        of this class to access this method
    */
    public static Abc getAbc() {
        return s;
    }


    // non static method1 which will only be accessible through class instance (object)
    public void method1() {
        System.out.println("This is method1");
    }
}

public class Client1 {

    public static void main(String[] args) {

        // assigining singleton class object to obj1 variable using static method
        Abc obj1 = Abc.getAbc();
        // assigining singleton class object to obj2 variable using static method
        Abc obj2 = Abc.getAbc();
        // assigining singleton class object to obj1 variable using static variable
        Abc obj3 = Abc.s;

        /*  printing hashcode of all the objects viz obj1, obj2 and obj3 repectively
            which will have same hashcode since all the variables are refering to
            single instance of 'Abc' class as this class is a singleton class
        */
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj3.hashCode());
    }
}