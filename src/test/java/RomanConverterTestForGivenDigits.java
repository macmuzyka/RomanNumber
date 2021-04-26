import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanConverterTestForGivenDigits extends BaseTest{

    @Test
    public void shouldReturnMMMCMXCIX() {
        assertEquals("MMMCMXCIX", converter.convertToRoman(3999));
    }

    @Test
    public void shouldReturnCCCXCIX() {
        assertEquals("CCCXCIX", converter.convertToRoman(399));
    }

    @Test
    public void shouldReturnXXXIX() {
        assertEquals("XXXIX", converter.convertToRoman(39));
    }

    @Test
    public void shouldReturnIII() {
        assertEquals("III", converter.convertToRoman(3));
    }
}