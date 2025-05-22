package StructuralPattern.ProxyPattern.example3.Solution;

/* 
    Internet interface from which real and proxy internet will extend
*/
public interface Internet {
    
    public void connectToSite(String siteURL) throws Exception;
}
