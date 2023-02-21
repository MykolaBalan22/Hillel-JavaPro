package task3;

public class IntegerSequence {
    public static int[] searchSum(int[] numbers, int target) {
        int[] result = new int[2];
        outer:
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] + numbers[i] == target) {
                    result[0] = i;
                    result[1] = j;
                    break outer;
                }
            }
        }
        return result;
    }
}
