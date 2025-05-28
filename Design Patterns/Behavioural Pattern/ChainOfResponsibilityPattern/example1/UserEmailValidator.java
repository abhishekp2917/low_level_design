package BehaviouralPattern.ChainOfResponsibilityPattern.example1.Solution;

/* 
    this class will validate user email entered by user 
*/
public class UserEmailValidator extends Validator{

    public UserEmailValidator(UserInput userInput, Database database) {
        super(userInput, database);
    }

    /*
        method to validate user email and return true or false based on outcome and 
        then calls next validator if avialable to validate the input  
    */
    @Override
    public boolean validate(UserInput userInput) {
        User user = database.getUser(userInput.getEmail());
        if(user!=null) {
            if(nextValidator!=null) return nextValidator.validate(userInput);
            else return true;
        }
        else{
            System.out.println("Invalid user email");
            return false;
        }
    }
}
