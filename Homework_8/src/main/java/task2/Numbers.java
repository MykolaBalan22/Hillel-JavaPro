package task2;

import java.util.Arrays;

public class Numbers {
    public static boolean containsDuplicate(int[] numbers) {
        return !Arrays.equals(Arrays.stream(numbers).distinct().toArray(), numbers);
    }
}
