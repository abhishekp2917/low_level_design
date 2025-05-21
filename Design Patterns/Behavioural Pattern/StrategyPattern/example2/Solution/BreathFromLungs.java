package BehaviouralPattern.StrategyPattern.example2.Solution;

/* 
    this class has perform functionality which breath from lungs
*/
public class BreathFromLungs implements Breath{

    @Override
    public String perform() {
        return "breathing from lungs";
    }
}
