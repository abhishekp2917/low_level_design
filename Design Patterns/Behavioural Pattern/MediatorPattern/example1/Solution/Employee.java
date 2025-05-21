package BehaviouralPattern.MediatorPattern.example1.Solution;

/* 
    Employee class who can resign and receive projects

    for resignation employee has to interact with HR and Manager for approval and  
    Accounatnt for salary settlement
    
    for receiving project it interact with Manager

    all this interaction is completed by mediator 
*/
public class Employee {

    private int employeeId;
    private String name;
    private Mediator mediator;
    private String project;

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    // method to set mediator
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.addEmployee(this.employeeId, this);
    }

    public String getName() {
        return name;
    }

    public String getProject() {
        return project;
    }

    // method to receive projects
    public void receiveProject(String project) {
        this.project = project;
    }

    // method to resign
    public void resign() {
        mediator.initiateResignationProcess(this);
    }
}
