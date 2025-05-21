package StructuralPattern.ProxyPattern.example3.Solution;

/* 
    RealInternet class from which one can create connection to any site
*/
public class RealInternet implements Internet{

    /* 
        method which establishes connection to different sites
    */
    @Override
    public void connectToSite(String siteURL) throws Exception {
        
        System.out.println("Connecting to site " + siteURL + "...");
        System.out.println("Connected successfully!");
        System.out.println("Fetching data...");
        System.out.println("Fetched successfully");
    }  
}
