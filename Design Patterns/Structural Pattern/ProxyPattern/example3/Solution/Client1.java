package StructuralPattern.ProxyPattern.example3.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        /* 
            creating proxy internet which acts as a protection layer of 
            actual internet
        */
        ProtectionProxyInternet internet = new ProtectionProxyInternet();

        /* 
            trying to connect to site which is not in banned list
        */
        try{
            internet.connectToSite("PQR");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        /* 
            trying to connect to site which is in banned list
        */
        try{
            internet.connectToSite("ABC");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
