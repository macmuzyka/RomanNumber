import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanConverterTest {

    private static RomanConverter converter;

    @BeforeAll
    static void setUp() {
        converter = new RomanConverter();
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWithZeroOrNegativeMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> converter.convertToRoman(0));
        String expectedMessage = "Zero or negative number!";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWithNumberTooGreatToBeConverted() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> converter.convertToRoman(4000));
        String expectedMessage = "Roman Number too great to be converted!";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldReturnMMMCMXCIX() {
        assertEquals("MMMCMXCIX", converter.convertToRoman(3999));
    }

    @Test
    void shouldReturnCCCXCIX() {
        assertEquals("CCCXCIX", converter.convertToRoman(399));
    }

    @Test
    void shouldReturnXXXIX() {
        assertEquals("XXXIX", converter.convertToRoman(39));
    }

    @Test
    void shouldReturnIII() {
        assertEquals("III", converter.convertToRoman(3));
    }
}