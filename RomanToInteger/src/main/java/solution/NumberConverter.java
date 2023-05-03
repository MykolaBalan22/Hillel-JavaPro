package solution;

import java.util.*;

public class NumberConverter {
    public static int romanToInteger(String romanNumbers) {
        Map<String, Integer> numbers = new LinkedHashMap<>();
        numbers.put("CM", 900);
        numbers.put("M", 1000);
        numbers.put("CD", 400);
        numbers.put("D", 500);
        numbers.put("XC", 90);
        numbers.put("C", 100);
        numbers.put("XL", 40);
        numbers.put("L", 50);
        numbers.put("IX", 9);
        numbers.put("X", 10);
        numbers.put("IV", 4);
        numbers.put("V", 5);
        numbers.put("I", 1);
        int result = 0;
        for (String line : numbers.keySet()) {
            while (romanNumbers.contains(line)) {
                result += numbers.get(line);
                romanNumbers = romanNumbers.replaceFirst(line, "");
            }
        }
        return result;
    }
}

