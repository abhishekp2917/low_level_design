package StructuralPattern.ProxyPattern.example3.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
    proxy internet which acts as protection layer and restricts banned sites
*/
public class ProtectionProxyInternet implements Internet{

    /* 
        creating RealInternet object to get access to methods that will be use to
        create internet connection
    */
    private Internet internet = new RealInternet();

    /* 
        list of all the banned sites  
    */
    private List <String> bannedSites = new ArrayList<>(Arrays.asList("ABC", "DEF", "XYZ"));

    /* 
        filtering the request and blocking access to banned sites
    */
    @Override
    public void connectToSite(String siteURL) throws Exception {
        if(bannedSites.contains(siteURL.toUpperCase())) {
            throw new Exception("\nAccess Denied to " + siteURL + "\n");
        }
        else {
            internet.connectToSite(siteURL);
        }
    }
}
