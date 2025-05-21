package BehaviouralPattern.StrategyPattern.example1.Solution;

/* 
    SDE2 extends employee class and develops low level software
*/
public class SDE2 extends Employee {
    
    public SDE2(String name, Task task, float experience, double salary) {
        this.name = name;
        this.task = task;
        this.experienceInYears = experience;
        this.salary = salary;
    }

    // method to develop software
    public void developSoftware() {
        this.task.performTask(this);
    }
}
