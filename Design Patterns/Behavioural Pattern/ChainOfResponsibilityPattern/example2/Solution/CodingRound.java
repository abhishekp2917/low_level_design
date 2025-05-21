package BehaviouralPattern.ChainOfResponsibilityPattern.example2.Solution;

/* 
    Codinground in which candidate will be tested for their coding skills
*/
public class CodingRound extends Round{

    // hire method for coding round
    @Override
    public boolean hire(Candidate candidate) {
        if(candidate.getCodingScore()>60) {
            if(this.nextRound!=null) return this.nextRound.hire(candidate);
            else return true;
        }
        System.out.println(candidate.getName() + " coundn't pass the Coding round");
        return false;
    }
}
