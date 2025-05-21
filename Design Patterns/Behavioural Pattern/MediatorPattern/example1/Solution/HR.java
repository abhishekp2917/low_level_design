package BehaviouralPattern.MediatorPattern.example1.Solution;

/* 
    HR class who can approve resignation request and fire an employee
    
    for firing an employee HR has to interact with Manager for approval and with 
    Accountant for salary settlement 

    all this interaction is completed by mediator 
*/
public class HR {

    private int HRId;
    private String name;
    private Mediator mediator;

    public HR(int HRId, String name) {
        this.HRId = HRId;
        this.name = name;
    }

    // method to set mediator
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.addHR(this);
    }

    public int getHRId() {
        return HRId;
    }

    public String getName() {
        return name;
    }

    // method to approve resignation
    public boolean approveResignation(Employee employee) {
        System.out.println(employee.getName() + " resignation has been approved by HR named " + this.getName());
        return true;
    }

    // method to fire an employee
    public void fireEmployee(Employee employee) {
        mediator.initiateFireEmployeeProcess(employee);
    }
}
