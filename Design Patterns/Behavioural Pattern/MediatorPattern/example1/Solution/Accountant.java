package BehaviouralPattern.MediatorPattern.example1.Solution;

/* 
    Accounatnt class who can settle salary
*/
public class Accountant {

    private int accountantId;
    private String name;
    private Mediator mediator;

    public Accountant(int accountantId, String name) {
        this.accountantId = accountantId;
        this.name = name;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.addAccountant(this);
    }

    public int getAccountantId() {
        return accountantId;
    }

    public String getName() {
        return name;
    }

    // method to settle salary of an employee
    public void settleSalary(Employee employee) {
        System.out.println("Settling salary of employee named " + employee.getName());
    }
}
