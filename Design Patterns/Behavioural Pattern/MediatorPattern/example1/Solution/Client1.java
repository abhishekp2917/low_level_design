package BehaviouralPattern.MediatorPattern.example1.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating HR object
        HR hr1 = new HR(123456, "Sanjay");
        
        // creating Manager object
        Manager manager1 = new Manager(123336, "Subham");

        // creating Accountant object
        Accountant accountant1 = new Accountant(123556, "Shivam");

        // creating employee
        Employee abhishek = new Employee(121156, "Abhishek");
        Employee ravi = new Employee(122256, "Ravi");

        // creating mediator
        Mediator peon = new Mediator();

        // setting mediator to all entity
        hr1.setMediator(peon);
        manager1.setMediator(peon);
        accountant1.setMediator(peon);
        abhishek.setMediator(peon);
        ravi.setMediator(peon);

        // manager allocating project to employeees
        manager1.allocateProject(abhishek, "E-commerce Application");
        manager1.allocateProject(ravi, "Database Configuration");

        System.out.println("Abhishek has been alloted project titled " + abhishek.getProject());
        System.out.println("Ravi has been alloted project titled " + ravi.getProject());
        System.out.println();

        // HR fired employee ravi
        hr1.fireEmployee(ravi);
        System.out.println();

        // employee abhishek resigned
        abhishek.resign();
    }
}
