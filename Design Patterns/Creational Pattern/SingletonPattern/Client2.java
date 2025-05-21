package CreationalPattern.SingletonPattern;


/*
    by creating singleton class using part1 method, object will be created even before 
    the need of object as object is assign to static variable and static variable is 
    initialized at the time of class loading.
    
    To prevent this from happening, object can be created when the static method 
    is called to get class object. 
    
    But due to this, new object will be created every time we call the method.

    To avoid multiple creation of object everytime this method is invoked, 
    one can check if object has been created or not. If the object has not
    created then create and return the object else just return the object 
*/

class Xyz{

    /*  declaring 'Xyz' (this) class static variable so that it will be accessible 
        from static getter method 

        Moreover, this variable is private because it will be initiallized only at the
        time of invoking getter method, so there is no need to declare this variable
        as public
    */
    private static Xyz s;


    /*  declaring class constructor as private so that no object
        can be created from outside of this class 
    */
    private Xyz() { 

        System.out.println("Object of class Xyz created");
    }


    /*  getter method to get this class object and declaring this method
        as static so that there would be no requirement to create object
        of this class to access this method
    */
    public static Xyz getXyz() {

        /*  creating 'Xyz' object inside method so that it will be created only when
            this method is invoked and if object is already created then this method
            will just return the object
        */
        if(s==null) s = new Xyz();
        return s;
    }


    // non static method1 which will only be accessible through class instance (object)
    public void method1() {
        System.out.println("This is method1");
    }
}

public class Client2 {
    
    public static void main(String[] args){

        // assigining singleton class object to obj1 variable using static method
        Xyz obj1 = Xyz.getXyz();
        // assigining singleton class object to obj2 variable using static method
        Xyz obj2 = Xyz.getXyz();

        /*  printing hashcode of all the objects viz obj1, obj2 repectively
            which will have same hashcode since all the variables are refering to
            single instance of 'Xyz' class as this class is a singleton class
        */
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
    }
}
