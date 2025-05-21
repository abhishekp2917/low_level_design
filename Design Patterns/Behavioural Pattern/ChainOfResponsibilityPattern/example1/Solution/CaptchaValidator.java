package BehaviouralPattern.ChainOfResponsibilityPattern.example1.Solution;

/* 
    this class validates captcha entered by user
*/
public class CaptchaValidator extends Validator{

    private String captcha;

    public CaptchaValidator(UserInput userInput, Database database, String captcha) {
        super(userInput, database);
        this.captcha = captcha;
    }

    /*
        method to validate captcha entered and return true or false based on outcome 
        and then calls next validator if avialable to validate the input  
    */
    @Override
    public boolean validate(UserInput userInput) {
        if(this.captcha.equals(userInput.getCaptcha())) {
            if(nextValidator!=null) {
                return nextValidator.validate(userInput);
            }
            else return true;
        }
        else{
            System.out.println("Wrong Captcha");
            return false;
        }
    }
}
