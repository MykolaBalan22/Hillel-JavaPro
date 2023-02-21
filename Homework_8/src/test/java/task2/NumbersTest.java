package task2;

import org.junit.Assert;
import org.junit.Test;

public class NumbersTest {
    @Test
    public void containsDuplicatePositiveTest() {
        int[] input = {1, 2, 3, 1};
        boolean actual = Numbers.containsDuplicate(input);
        Assert.assertTrue(actual);
    }

    @Test
    public void containsDuplicateNegativeTest() {
        int[] input = {1, 2, 3, 4};
        boolean actual = Numbers.containsDuplicate(input);
        Assert.assertFalse(actual);
    }
}
