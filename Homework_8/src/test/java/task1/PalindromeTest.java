package task1;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {
    @Test
    public void isPalindromePositiveTest() {
        String inputLine = "A man, a plan, a canal: Panama";
        boolean actual = Palindrome.isPalindrome(inputLine);
        Assert.assertTrue(actual);
    }

    @Test
    public void isPalindromeNegativeTest() {
        String inputLine = "race a car";
        boolean actual = Palindrome.isPalindrome(inputLine);
        Assert.assertFalse(actual);
    }

    @Test
    public void isPalindromeEmptyTest() {
        String inputLine = " ";
        boolean actual = Palindrome.isPalindrome(inputLine);
        Assert.assertTrue(actual);
    }
}
