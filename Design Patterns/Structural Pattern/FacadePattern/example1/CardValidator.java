// CardValidator interface defines a contract for validating card details.
public interface CardValidator {

    // Validates the provided card and returns true if it's valid, false otherwise.
    boolean validate(Card card);
}
