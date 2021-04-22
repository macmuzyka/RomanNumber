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
    public void shouldThrowIllegalArgumentExceptionWithZeroOrNegativeMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> converter.convertToRoman(0));
        String expectedMessage = "Zero or negative number!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWithNumberTooGreatToBeConverted() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> converter.convertToRoman(4000));
        String expectedMessage = "Roman Number too great to be converted!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
