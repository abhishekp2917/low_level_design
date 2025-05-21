package BehaviouralPattern.StrategyPattern.example1.Solution;


/* 
    Devops Engineer extends employee class and creates CICD pipeline
*/
public class DevopsEngineer extends Employee{
    
    public DevopsEngineer(String name, Task task, float experience, double salary) {
        this.name = name;
        this.task = task;
        this.experienceInYears = experience;
        this.salary = salary;
    }

    // method to create CICD pipeline
    public void makeCICDPipeline() {
        this.task.performTask(this);
    }
}
