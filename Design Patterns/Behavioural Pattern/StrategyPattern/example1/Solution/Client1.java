package BehaviouralPattern.StrategyPattern.example1.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating different task 
        // task to develop software using java language
        Task ecomerceBackend = new DevelopJavaSoftware("E-Commerce Backend", 60);
        // task to develop software using nodejs language
        Task bankingBackend = new DevelopNodejsSoftware("Banking Backend", 120);
        // task to deploy software using AWS devops tool
        Task ecomerceDeployment = new AWSDevops("E-Commerce Deployment", 30);


        // creating employees and assiging task to each employee
        SDE1 abhishek = new SDE1("abhishek", ecomerceBackend, 1, 1000000);
        SDE2 avinash = new SDE2("avinash", ecomerceBackend, 2, 1500000);
        SDE2 suraj = new SDE2("suraj", bankingBackend, 2, 1500000);
        DevopsEngineer ravi = new DevopsEngineer("ravi", ecomerceDeployment, 1.5f, 1500000);

        // employee performing there task
        abhishek.developSoftware();
        avinash.developSoftware();
        suraj.developSoftware();
        ravi.makeCICDPipeline();

        // changing task of avinash from developing ecomerce java app to banking nodejs app
        avinash.updateRole(bankingBackend);

        // changing task of suraj from developing banking nodejs app to ecomerce java app
        suraj.updateRole(ecomerceBackend);

        System.out.println("\n==================latest task======================\n");

        // employee performing there latest task
        abhishek.developSoftware();
        avinash.developSoftware();
        suraj.developSoftware();
        ravi.makeCICDPipeline();
    }
}
