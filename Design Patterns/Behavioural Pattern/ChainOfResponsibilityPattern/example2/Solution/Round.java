package BehaviouralPattern.ChainOfResponsibilityPattern.example2.Solution;

/* 
    Round is an abstract class from which concrete class will be created such as 
    CodingRound in which candidate will be judge based on coding skills, 
    technicalRound for testing technical skills etc

    after each round if candidate clears the current round then is next round is 
    there then it has to clear next round
*/
public abstract class Round {
    
    protected Round nextRound;

    // method to set next round
    public void setNextRound(Round nextRound) {
        this.nextRound = nextRound;
    }

    // method to hire candidate
    public abstract boolean hire(Candidate candidate); 
}
