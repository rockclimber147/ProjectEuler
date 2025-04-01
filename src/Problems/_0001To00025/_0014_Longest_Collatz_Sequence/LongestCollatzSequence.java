package Problems._0001To00025._0014_Longest_Collatz_Sequence;

import Stats.Counter;
import Stats.RunInfo;

import java.util.HashMap;
import java.util.Stack;

public class LongestCollatzSequence {
    private static final int maxNumber = 1000000;

    private static long getNextCollatzNumber(long number) {
        if (Counter.countCondition(number % 2 == 0)) {
            return number / 2;
        } else {
            return number * 3 + 1;
        }
    }

    public static void solutionNaive() {
        int maxSequenceLength = 0;
        int numberWithHighestSequence = 0;
        for (int i = 1; Counter.countCondition(i < maxNumber); i++) {
            Counter.incrementLoopCount();
            int collatzLength = getCollatzSequenceLength(i);
            if (Counter.countCondition(collatzLength > maxSequenceLength)) {
                maxSequenceLength = collatzLength;
                numberWithHighestSequence = i;
            }
        }
        System.out.println(numberWithHighestSequence + " has sequence length " + maxSequenceLength);
    }

    private static int getCollatzSequenceLength(long number) {
        int sequenceLength = 1;
        while (Counter.countCondition(number != 1)) {
            Counter.incrementLoopCount();
            number = getNextCollatzNumber(number);
            sequenceLength++;
        }
        return sequenceLength;
    }

    public static void solutionWithCaching() {
        HashMap<Long, Integer> numberToSequenceLength = new HashMap<>();
        numberToSequenceLength.put(1L, 1);

        int maxSequenceLength = 0;
        int numberWithHighestSequence = 0;

        for (int i = 1; Counter.countCondition(i < maxNumber); i++) {
            Counter.incrementLoopCount();
            int collatzLength = getCollatzSequenceLengthWithCache(i, numberToSequenceLength);
            if (Counter.countCondition(collatzLength > maxSequenceLength)) {
                maxSequenceLength = collatzLength;
                numberWithHighestSequence = i;
            }
        }

        System.out.println(numberWithHighestSequence + " has sequence length " + maxSequenceLength);
    }

    private static int getCollatzSequenceLengthWithCache(long number, HashMap<Long, Integer> cache) {
        Stack<Long> numbersChecked = new Stack<>();
        long originalNumber = number;

        while (Counter.countCondition(!cache.containsKey(number))) {
            Counter.incrementLoopCount();
            numbersChecked.push(number);

            number = getNextCollatzNumber(number);
        }

        int sequenceLength = cache.get(number);
        while (Counter.countCondition(!numbersChecked.isEmpty())) {
            Counter.incrementLoopCount();
            sequenceLength++;
            cache.put(numbersChecked.pop(), sequenceLength);
        }

        return cache.get(originalNumber);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(LongestCollatzSequence::solutionNaive);
        RunInfo.executeWithInfo(LongestCollatzSequence::solutionWithCaching);
    }
}
