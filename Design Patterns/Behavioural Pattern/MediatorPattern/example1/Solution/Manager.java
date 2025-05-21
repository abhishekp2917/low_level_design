package BehaviouralPattern.MediatorPattern.example1.Solution;


/* 
    Manager class who can approve resignation request, approve firing of an employee 
    and can allocate project to employee
    
    for allocating project it has to interact with employee

    all this interaction is completed by mediator 
*/
public class Manager {

    private int managerId;
    private String name;
    private Mediator mediator;

    public Manager(int managerId, String name) {
        this.managerId = managerId;
        this.name = name;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.addManager(this);
    }

    public int getManagerId() {
        return managerId;
    }

    public String getName() {
        return name;
    }
    
    // method to approve resignation
    public boolean approveResignation(Employee employee) {
        System.out.println(employee.getName() + " resignation has been approved by Manager named " + this.getName());
        return true;
    }

    // method to allocate project to an employee
    public void allocateProject(Employee employee, String project) {
        mediator.initiateProjectAllocationProcess(employee, project);
    }

    // method to approve firing an employee
    public boolean approveFiring(Employee employee) {
        System.out.println(employee.getName() + " firing has been approved by Manager named " + this.getName());
        return true;
    }
}
