package BehaviouralPattern.StrategyPattern.example1.Solution;

/* 
    this class has implementation logic for creating CICD pipeline using AWS devops 
    tools
*/
public class AWSDevops implements Task {

    private String projectName;
    private int noOfDays;

    public AWSDevops(String name, int days) {
        this.projectName = name;
        this.noOfDays = days;
    }

    // overriding performTask method to create CICD pipeline using AWS devops tools
    @Override
    public void performTask(Employee employee) {
        System.out.println(employee.name + " Creating CICD pipeline using AWS tools");
        System.out.println("Project name : " + this.projectName); 
        System.out.println("Develop software within " + this.noOfDays + " Days\n");
    }
}
