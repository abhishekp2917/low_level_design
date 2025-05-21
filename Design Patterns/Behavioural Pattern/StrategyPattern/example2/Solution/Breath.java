package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    Breath interface which will have concrete implementation of different way of
    breathing which will be use by animal object to breath
*/
public interface Breath {
    
    // method to perform breathing
    public String perform();
}
