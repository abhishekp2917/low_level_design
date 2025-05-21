package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    this class has perform functionality which breath from gills
*/
public class BreathFromGills implements Breath{
    
    @Override
    public String perform() {
        return "breathing from gills";
    }
}

