package BehaviouralPattern.StrategyPattern.example1.Solution;

/* 
    Role interface which concrete role class will extend 
    this interface has only one method i.e, to perform task
*/
public interface Task {
    
    public void performTask(Employee employee);
}
