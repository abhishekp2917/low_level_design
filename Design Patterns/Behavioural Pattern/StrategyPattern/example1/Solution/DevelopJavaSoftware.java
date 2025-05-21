package BehaviouralPattern.StrategyPattern.example1.Solution;

/* 
    this class has implementation logic for developing software using java language
*/
public class DevelopJavaSoftware implements Task{
    
    private String projectName;
    private int noOfDays;

    public DevelopJavaSoftware(String name, int days) {
        this.projectName = name;
        this.noOfDays = days;
    }

    // overriding performTask method to develop software using java language
    @Override
    public void performTask(Employee employee) {
        System.out.println(employee.name + " Developing Java software");
        System.out.println("Project name : " + this.projectName); 
        System.out.println("Develop software within " + this.noOfDays + " Days\n");       
    }
}
