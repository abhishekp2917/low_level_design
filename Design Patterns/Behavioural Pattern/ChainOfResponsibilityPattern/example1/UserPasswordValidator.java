package BehaviouralPattern.ChainOfResponsibilityPattern.example1.Solution;

/* 
    this class validates user password
*/
public class UserPasswordValidator extends Validator {

    public UserPasswordValidator(UserInput userInput, Database database) {
        super(userInput, database);
    }

    /*
        method to validate user password and return true or false based on outcome and 
        then calls next validator if avialable to validate the input  
    */
    @Override
    public boolean validate(UserInput userInput) {
        User user = database.getUser(userInput.getEmail());
        if(user.getPassword().equals(userInput.getPassword())) {
            if(nextValidator!=null) return nextValidator.validate(userInput);
            else return true;
        }
        else{
            System.out.println("Invalid password");
            return false;
        }
    }
    
}
