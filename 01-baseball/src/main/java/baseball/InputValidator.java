package baseball;

public class InputValidator {

    private static final String REGEX = "^[1-9]{" + Computer.NUMBER_LENGTH + "}$";

    private InputValidator() {
    }

    public static void validate(String input) {
        validateFormat(input);
        validateDistinct(input);
    }

    private static void validateFormat(String input) {
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDistinct(String input) {
        if (input.chars().distinct().count() != Computer.NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
