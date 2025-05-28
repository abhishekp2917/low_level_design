package BehaviouralPattern.ChainOfResponsibilityPattern.example1.Solution;

/* 
    UserInput class which will have info about input entered by user to login
*/
public class UserInput {
    
    private String email;
    private String password;
    private String captcha;

    public UserInput(String email, String password, String captcha) {
        this.email = email;
        this.password = password;
        this.captcha = captcha;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCaptcha() {
        return captcha;
    }
}
