/**
 * Created by Maciej Muzyka
 * on 25.04.2021
 */

class RomanNumberValidator {
    private static final int ROMAN_MAX_CONVERTIBLE_NUMBER = 3999;
    private static final int ROMAN_MIN_CONVERTIBLE_NUMBER = 1;

    static void validatingInput(final int input) {
        if (input > ROMAN_MAX_CONVERTIBLE_NUMBER) {
            throw new OutOfBoundsException("Roman Number too great to be converted!");
        } else if (input < ROMAN_MIN_CONVERTIBLE_NUMBER) {
            throw new OutOfBoundsException("Zero or negative number!");
        }
    }
}
