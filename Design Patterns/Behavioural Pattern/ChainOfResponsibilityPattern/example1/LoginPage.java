package BehaviouralPattern.ChainOfResponsibilityPattern.example1.Solution;

import java.util.Scanner;

/* 
    this class has info about login page and will be used to login and get access to
    user page 
*/
public class LoginPage {

    private Database database;
    private String captcha;
    private Validator emailValidator;
    private Validator passwordValidator;
    private Validator captchaValidator;


    public LoginPage(Database database, String captcha) {
        this.database = database;
        this.captcha = captcha;
    }

    // method to login and get access to user page
    public void login() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter user email :");
        String inputEmail = sc.next();

        System.out.println("Enter user password :");
        String inputPassword = sc.next();

        System.out.println("Enter captcha '" + this.captcha + "' :");
        String inputCaptcha = sc.next();
        sc.close();

        UserInput userInput = new UserInput(inputEmail, inputPassword, inputCaptcha);

        this.emailValidator = new UserEmailValidator(userInput, database);
        this.passwordValidator = new UserPasswordValidator(userInput, database);
        this.captchaValidator = new CaptchaValidator(userInput, database, captcha);

        this.emailValidator.setNextValidator(passwordValidator);
        this.passwordValidator.setNextValidator(captchaValidator);

        boolean loginStatus = this.emailValidator.validate(userInput);

        if(loginStatus==true) {
            UserPage page = new UserPage(userInput.getEmail(), userInput.getPassword());
            page.display();
        }
    }
}
