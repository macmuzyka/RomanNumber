import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Maciej Muzyka
 * on 22.04.2021
 * TODO:
 */

public class RomanConverterTestForExceptions {

    private static RomanConverter converter;

    @Before
    public void initialize() {
        converter = new RomanConverter();
    }

    @Test
    public void shouldThrowOutOfBoundsExceptionWithZeroOrNegativeMessage() {
        Exception exception = getExceptionForInvalidNumberInput(0);
        String expectedMessage = getExpectedMessageFromExceptionThrown("Zero or negative number!");
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldThrowOutOfBoundsExceptionWithNumberTooGreatToBeConverted() {
        Exception exception = getExceptionForInvalidNumberInput(4000);
        String expectedMessage = getExpectedMessageFromExceptionThrown("Roman Number too great to be converted!");
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    private Exception getExceptionForInvalidNumberInput(final int outOfBoundsNumberToBeConverted) {
        return assertThrows(OutOfBoundsException.class, () -> converter.convertToRoman(outOfBoundsNumberToBeConverted));
    }

    @NotNull
    private String getExpectedMessageFromExceptionThrown(String exceptionThrownMessage) {
        return exceptionThrownMessage;
    }
}
