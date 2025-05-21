package BehaviouralPattern.ChainOfResponsibilityPattern.example2.Solution;

/* 
    Panel clas which will have various round that candidate has to pass one after 
    the another and very first round here is coding round
*/
public class Panel {

    private Round round1;
    private Round round2;
    private Round round3;

    /*  
        calling panel constructor which will create various rounds and make a chain
        out of it so that each round conduct in sequence 
    */
    public Panel() {
        this.round1 = new CodingRound();
        this.round2 = new TechnicalRound();
        this.round3 = new HRRound();

        round1.setNextRound(round2);
        round2.setNextRound(round3);
    }

    // method to hire candidate and judge the candidate based on each round
    public void hire(Candidate candidate) {
        boolean roundStatus = round1.hire(candidate);

        if(roundStatus==true) System.out.println(candidate.getName() + " has been selected");
        else System.out.println(candidate.getName() + " has been rejected");
    }
}
