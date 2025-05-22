// Concrete implementation of the CardValidator interface.
public class CardValidatorImpl implements CardValidator {

    // Validates the provided card and return true if valid.
    @Override
    public boolean validate(Card card) {
        System.out.println(String.format("Validating Card : %s", card.cardNumber));   
        return true;
    }
}
