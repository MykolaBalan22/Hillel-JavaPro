package task1;

import java.util.Arrays;

public class Palindrome {
    public static boolean isPalindrome(String line) {
        String allInOneWord = Arrays.stream(line.split(" "))
                .map(s -> s.replaceAll("\\p{Punct}", ""))
                .map(String::toLowerCase)
                .filter(s -> !s.isEmpty())
                .reduce((s1, s2) -> s1 + s2)
                .orElse(" ");
        return new StringBuilder(allInOneWord).
                reverse()
                .toString()
                .equals(allInOneWord);
    }
}
