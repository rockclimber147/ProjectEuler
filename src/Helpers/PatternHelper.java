package Helpers;

import Stats.Counter;

public class PatternHelper {
    public static boolean isPalindrome(long number) {
        int mostSignificantDigitPosition = (int) Math.log10(number) + 1;
        int leastSignificantDigitPosition = 1;

        while (Counter.countCondition(mostSignificantDigitPosition > leastSignificantDigitPosition)) {
            Counter.incrementLoopCount();
            int moreSignificantDigit = digitAt(number, mostSignificantDigitPosition);
            int lessSignificantDigit = digitAt(number, leastSignificantDigitPosition);
            if (Counter.countCondition(moreSignificantDigit != lessSignificantDigit)) {
                return false;
            }
            mostSignificantDigitPosition--;
            leastSignificantDigitPosition++;
        }
        return true;
    }

    public static int digitAt(long number, int index) {
        if (Counter.countCondition(index == 0)) {
            // Special case for the first digit
            return (int) (number % 10);
        } else {
            // Calculate the digit at the specified index using modulus and division
            long divisor = (long) Math.pow(10, index);
            return (int) ((number % divisor) / (divisor / 10));
        }
    }
}
