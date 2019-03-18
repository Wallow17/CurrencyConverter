/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    Parse parsed = new Parse();
    
    @Test
    public void basicConvUSDToUSD() {
        assertEquals(Float.valueOf(1), parsed.make_conversion("USD", "USD", 1.0f));
    }

    @Test
    public void basicConvEURToEUR() {
        assertEquals(Float.valueOf(12345), parsed.make_conversion("EUR", "EUR", 12345.0f));
    }
}
