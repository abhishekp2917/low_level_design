package BehaviouralPattern.ChainOfResponsibilityPattern.example1.Solution;

/* 
    user page which will have info about userpage and will be used to display user 
    page once user login successfully
*/
public class UserPage {
    
    private String email;
    private String password;

    public UserPage(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // method to display userpage
    public void display() {
        System.out.println("Header section");
        System.out.println("Welcome to user profile Page");
        System.out.println("User email : " + this.email);
        System.out.println("User password : " + this.password);
        System.out.println("Footer Section");
    }
}
