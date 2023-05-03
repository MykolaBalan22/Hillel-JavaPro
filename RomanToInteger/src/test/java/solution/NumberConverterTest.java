package solution;

import org.junit.Assert;
import org.junit.Test;

public class NumberConverterTest {
    @Test
    public void romanToIntegerTest() {
        String inputLine = "MCMXCIV";
        int expected = 1994;
        int actual = NumberConverter.romanToInteger(inputLine);
        Assert.assertEquals(expected, actual);
    }
}
