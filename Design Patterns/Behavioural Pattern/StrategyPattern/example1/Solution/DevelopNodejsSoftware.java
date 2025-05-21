package BehaviouralPattern.StrategyPattern.example1.Solution;

/* 
    this class has implementation logic for developing software using nodejs language
*/
public class DevelopNodejsSoftware implements Task{

    private String projectName;
    private int noOfDays;

    public DevelopNodejsSoftware(String name, int days) {
        this.projectName = name;
        this.noOfDays = days;
    }

    // overriding performTask method to develop software using nodejs language
    @Override
    public void performTask(Employee employee) {
        System.out.println(employee.name + " Developing Nodejs software");
        System.out.println("Project name : " + this.projectName); 
        System.out.println("Develop software within " + this.noOfDays + " Days\n");       
    }
}
