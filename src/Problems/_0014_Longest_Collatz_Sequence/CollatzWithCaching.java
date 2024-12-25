package Problems._0014_Longest_Collatz_Sequence;

import java.util.HashMap;
import java.util.Map;

public class CollatzWithCaching {
    private static int maxNumber = 1000000;
    private static Map<Long, Integer> memo = new HashMap<>();

    public static void solutionOptimized() {
        int maxSequenceLength = 0;

        for (int i = 1; i < maxNumber; i++) {
            int collatzLength = getCollatzSequenceLength(i);
            if (collatzLength > maxSequenceLength) {
                maxSequenceLength = collatzLength;
            }
            System.out.println(i);
        }
        System.out.println(maxSequenceLength);
    }

    private static int getCollatzSequenceLength(long number) {
        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        int sequenceLength = 1;
        long originalNumber = number;

        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            sequenceLength++;

            // Memoize the length for each intermediate number
            if (!memo.containsKey(number)) {
                memo.put(number, sequenceLength);
            }
        }

        memo.put(originalNumber, sequenceLength);
        return sequenceLength;
    }

    public static void main(String[] args) {
        solutionOptimized();
    }
}
