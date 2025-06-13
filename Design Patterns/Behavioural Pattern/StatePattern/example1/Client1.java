/**
 * Client1 simulates user interactions with the ATM to demonstrate
 * how the State Pattern manages different states and transitions.
 */
public class Client1 {

    public static void main(String[] args) {

        // Initialize ATM with ₹3000 cash
        ATMMachine sbiATM = new ATMMachine(3000);

        // --- Interaction 1 ---
        // Insert card (ATM is in NoCardState initially)
        // Should transition to HasCardState
        sbiATM.insertCard();

        // --- Interaction 2 ---
        // Eject card (ATM is in HasCardState)
        // Should transition back to NoCardState
        sbiATM.ejectCard();

        // --- Interaction 3 ---
        // Try entering PIN without inserting card
        // Invalid operation (ATM is in NoCardState)
        sbiATM.enterPIN(1234);

        // --- Interaction 4 ---
        // Try withdrawing cash without inserting card
        // Invalid operation (ATM is in NoCardState)
        sbiATM.requestCash(1500);

        // --- Interaction 5 ---
        // Insert card again (valid)
        sbiATM.insertCard();

        // --- Interaction 6 ---
        // Enter correct PIN (should transition to HasPinState)
        sbiATM.enterPIN(1234);

        // --- Interaction 7 ---
        // Withdraw ₹1500 (valid, sufficient balance)
        // Should reduce cash and return to NoCardState
        sbiATM.requestCash(1500);

        // --- Interaction 8 ---
        // Try withdrawing ₹1500 again
        // No card inserted now, so should prompt to insert card
        sbiATM.requestCash(1500);

        // --- Interaction 9 ---
        // Insert card again
        sbiATM.insertCard();

        // --- Interaction 10 ---
        // Enter correct PIN again
        sbiATM.enterPIN(1234);

        // --- Interaction 11 ---
        // Request ₹2000, but ATM only has ₹1500 left now
        // Should fail due to insufficient funds
        // ATM will then transition to NoCardState
        sbiATM.requestCash(2000);
    }
}
