package BehaviouralPattern.ChainOfResponsibilityPattern.example1.Solution;

/* 
    Validator abstract class which will be have different concrete validator class
    like user email validator to validate email, password validator to validate 
    password
*/
public abstract class Validator {
    
    protected UserInput userInput;
    protected Database database;
    protected Validator nextValidator;

    public Validator(UserInput userInput, Database database) {
        this.userInput = userInput;
        this.database = database;
    }

    /*  
        method to set next validator which will validate after current validator 
        completes validation
    */
    public void setNextValidator(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    // method to validate userinput
    public abstract boolean validate(UserInput userInput);
}
