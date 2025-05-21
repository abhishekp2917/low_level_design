package BehaviouralPattern.StrategyPattern.example1.Solution;


/* 
    Employee abstract class which has one method to update employee role
*/
public abstract class Employee {
    
    protected String name;
    protected Task task;
    protected float experienceInYears;
    protected double salary;

    public void updateRole(Task task) {
        this.task = task;
    }
}