package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    this class has perform functionality which breath from skin
*/
public class BreathFromSkin implements Breath{

    @Override
    public String perform() {
        return "breathing from skin";
    }
    
}
