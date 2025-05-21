package BehaviouralPattern.ChainOfResponsibilityPattern.example2.Solution;

/* 
    TechnicalRound in which candidate will be tested for their technical skills
*/
public class TechnicalRound extends Round {

    // hire method for technical round
    @Override
    public boolean hire(Candidate candidate) {
        if(candidate.getTechnicalScore()>70) {
            if(this.nextRound!=null) return this.nextRound.hire(candidate);
            else return true;
        }
        System.out.println(candidate.getName() + " coundn't pass the Technical round");
        return false;
    }
}
