package task3;

import org.junit.Assert;
import org.junit.Test;

public class IntegerSequenceTest {
    @Test
    public void searchSumTest() {
        int[] inputArray = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        int[] actual = IntegerSequence.searchSum(inputArray, target);
        Assert.assertArrayEquals(expected, actual);

    }
}
