package CreationalPattern.SingletonPattern;


/*
    by creating singleton class using part2 method there is a chance of multiple
    object being created is the class getter method if invoked by different threads.
    
    To avoid this one must synchronize the getter method so that when the method
    is invoked by one thread then other thread must wait which will prevent multiple
    object creation.

    But declaring getter method as synchronized will slow down our application, so to
    avoid this from happening, we can use 'double checking lock' method in which after
    checking static variable value, we will again check same condition inside the 
    previous condition using synchronized block due to which thread will wait for 
    that synchronized block which will result in less waiting time. 
*/

class Pqr{

    /*  Creating 'Pqr' (this) class object and assigining it to 
        static variable so that there is no need to create the object of 
        this class to access this variable.

        Moreover, this variable will be accessible inside static getter method
    */
    static Pqr s;


    /*  declaring class constructor as private so that no object
        can be created from outside of this class 
    */
    private Pqr() {

        System.out.println("Object of class Pqr created");
    }


    /*  getter method to get this class object and declaring this method
        as static so that there would be no requirement to create object
        of this class to access this method

        making this method as synchronized as this will prevent multiple
        object creation by multiple threads
    */
    public static Pqr getPqr() {

        /*   
            using synchronized block inside if block to avoid multiple object
            creation by multiple threads
        */
        if(s==null) {

            synchronized(Pqr.class) {
                
                if(s==null) s = new Pqr();
            }
        }
        return s;
    }


    // non static method1 which will only be accessible through class instance (object)
    public void method1() {
        System.out.println("This is method1");
    }
}

public class Client3 {
    
    public static void main(String[] args){

        // creating first thread object 
        Thread t1 = new Thread(new Runnable() {
            
            public void run() {

                // assigining singleton class object to obj1 variable using static method
                Pqr obj1 = Pqr.getPqr();
       
                // printing hashcode of the object obj1 
                System.out.println(obj1.hashCode());
            }
        });

        // creating second thread object
        Thread t2 = new Thread(new Runnable() {
            
            public void run() {

                // assigining singleton class object to obj2 variable using static method
                Pqr obj2 = Pqr.getPqr();

                // printing hashcode of the object obj2 
                System.out.println(obj2.hashCode());
            }
        });

        // starting both the threads
        t1.start();
        t2.start();
    }
}
