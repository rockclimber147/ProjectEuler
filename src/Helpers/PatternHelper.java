package Helpers;

import Stats.Counter;

public class PatternHelper {
    public static final int CHAR_INT_OFFSET = 48;

    public static int charToInt(char character) {
        return character - CHAR_INT_OFFSET;
    }
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

    public static int sumOfDigits(final String number) {
        char[] digits = number.toCharArray();
        int total = 0;
        for (int i = 0; Counter.countCondition(i < digits.length); i++) {
            Counter.incrementConditionalCount();
            total += PatternHelper.charToInt(digits[i]);
        }
        return total;
    }

    public static int getAmicableNumber(int input) {
        int sumOfInputFactors = FactorHelper.getSumOfProperDivisors(input);

        if (Counter.countCondition(sumOfInputFactors == input)) {
            return -1;
        }
        int sumOfOutputFactors = FactorHelper.getSumOfProperDivisors(sumOfInputFactors);

        if (Counter.countCondition(sumOfOutputFactors == input)) {
            return sumOfInputFactors;
        }
        return -1;
    }

    public static long binaryRepresentationAsDecimal(long decimal) {
        long binaryRep = 0;
        long mask = 1;
        long add = 1;
        while (mask <= decimal) {
            if ((mask & decimal) > 0) binaryRep += add;
            mask <<= 1;
            add *= 10;
        }
        return binaryRep;
    }

    public static long setNthDigitToZero(long number, int n) {
        long leftPart = number / (long) Math.pow(10, n);

        long rightPart = number % (long) Math.pow(10, n);

        rightPart = rightPart % (long) Math.pow(10, n - 1);

        return leftPart * (long) Math.pow(10, n) + rightPart;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 16; i++) {
            System.out.println(binaryRepresentationAsDecimal(i));
        }

//        System.out.println(setNthDigitToZero(1234, 1));
    }
}
