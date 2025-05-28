package BehaviouralPattern.ChainOfResponsibilityPattern.example1.Solution;

/* 
    user class which has user info and will be used to store in user database
*/
public class User {
    
    private String email;
    private String password;

    User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
