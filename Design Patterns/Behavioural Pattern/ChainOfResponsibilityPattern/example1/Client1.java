package BehaviouralPattern.ChainOfResponsibilityPattern.example1.Solution;

public class Client1 {
    
    public static void main(String[] args) {
        
        // creating database to store user data
        Database userDatabase = new Database();

        // adding users in database
        userDatabase.addUser(new User("abc@gmail.com", "abc123"));
        userDatabase.addUser(new User("def@gmail.com", "def123"));
        userDatabase.addUser(new User("ghi@gmail.com", "ghi123"));

        // creating login page
        LoginPage userLoginPage = new LoginPage(userDatabase, "AbC12f");

        // login to account through login page
        userLoginPage.login();
    }
}
