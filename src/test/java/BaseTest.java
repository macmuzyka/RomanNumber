import org.junit.After;
import org.junit.Before;

/**
 * Created by Maciej Muzyka
 * on 26.04.2021
 */

class BaseTest {
    protected static RomanConverter converter;

    @Before
    public void setUp() {
        converter = new RomanConverter();
    }

    @After
    public void tearDown() {
        converter = null;
    }
}
