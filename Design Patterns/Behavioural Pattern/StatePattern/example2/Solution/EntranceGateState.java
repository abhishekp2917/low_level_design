package BehaviouralPattern.StatePattern.example2.Solution;

/* 
    EntranceGateState interface which has concrete state that has all the behaviours 
    that entrance gate has but each state have different logic based on the state
*/
public interface EntranceGateState {
    
    public void paymentFailed();

    public void paymentSuccessfull();

    public void payAmount();

    public void entered();
}
