package BehaviouralPattern.MediatorPattern.example1.Solution;

import java.util.HashMap;

/*
    Mediator class which will make interaction between two object possible
    for instance interaction between Employee and Manager, Manager and HR etc
*/
public class Mediator {

    private HashMap<Integer, Employee> employeeList = new HashMap<>();
    private HR HR;
    private Manager manager;
    private Accountant accountant;

    public void addEmployee(int employeeId, Employee newEmployee) {
        employeeList.put(employeeId, newEmployee);
    }

    public void addHR(HR newHR) {
        this.HR = newHR;
    }

    public void addManager(Manager newManager) {
        this.manager = newManager;
    }

    public void addAccountant(Accountant newAccountant) {
        this.accountant = newAccountant;
    }

    /*  
        method to initiate resignation process in which employee interact with HR, 
        Manager and Accountant
    */
    public void initiateResignationProcess(Employee employee) {
        boolean hrResponse = HR.approveResignation(employee);
        boolean managerResponse = manager.approveResignation(employee);
        if(hrResponse==true && managerResponse==true) accountant.settleSalary(employee);
    }

    /*  
        method to initiate firing of an employee process in which HR interact with 
        Manager and Accountant
    */
    public void initiateFireEmployeeProcess(Employee employee) {
        boolean managerResponse = manager.approveFiring(employee);
        if(managerResponse==true) accountant.settleSalary(employee);
    }

    /* 
        method to initiate project allocation to an employee in which Manager 
        interact with Employee
    */
    public void initiateProjectAllocationProcess(Employee employee, String project) {
        employee.receiveProject(project);
    }
}
