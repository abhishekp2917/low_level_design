package BehaviouralPattern.ChainOfResponsibilityPattern.example2.Solution;

/* 
    HRRound in which candidate will be tested for their experience
*/
public class HRRound extends Round {

    // hire method for HR round
    @Override
    public boolean hire(Candidate candidate) {
        if(candidate.getExperience()>1.6) {
            if(this.nextRound!=null) return this.nextRound.hire(candidate);
            else return true;
        }
        System.out.println(candidate.getName() + " coundn't pass the HR round");
        return false;
    }
}
