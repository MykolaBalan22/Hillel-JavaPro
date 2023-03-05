package task1;

import org.junit.Assert;
import org.junit.Test;

public class ProfitTest {
    @Test
    public void maxProfitTets(){
        int[] inputArray = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        int actual =Profit.maxProfit(inputArray);
        Assert.assertEquals(expected, actual);
    }
}
