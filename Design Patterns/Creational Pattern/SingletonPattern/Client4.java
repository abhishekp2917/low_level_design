package CreationalPattern.SingletonPattern;


/*
    implementing singleton pattern using 'enum' which is similar to part1 method.

    enum is similar to class and final by default
*/

enum Blue {

    /* 
        this is similar to -

        Public static final Blue INSTANCE = new Blue();

        and will create an object of this class and assign it to this
        static variable name 'INSTANCE'

        There is no need to create a getter method for this enum as one can access
        the object from this static variable
    */ 
    INSTANCE;


    // enum constructor which private by default
    Blue() {

        System.out.println("Object of class Blue created");
    }


    //  non static method1 which will only be accessible through class instance (object)
    public void method1() {

        System.out.println("This is method1");
    }
}

public class Client4 {
    
    public static void main(String[] args) {

        // assigining singleton class object to obj1 variable using enum constants
        Blue obj1 = Blue.INSTANCE;
        // assigining singleton class object to obj2 variable using enum constants
        Blue obj2 = Blue.INSTANCE;

        /*  printing hashcode of all the objects viz obj1, obj2 repectively
            which will have same hashcode since all the variables are refering to
            single instance of 'Blue' class as this class is a singleton class
        */
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
    }
}
