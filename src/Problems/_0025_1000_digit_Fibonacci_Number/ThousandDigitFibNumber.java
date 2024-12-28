package Problems._0025_1000_digit_Fibonacci_Number;

import Stats.Counter;
import Stats.RunInfo;

import java.math.BigInteger;

public class ThousandDigitFibNumber {
    private static final int TARGET_DIGIT_COUNT = 1000;
    public static void solution() {
        BigInteger prev = new BigInteger("1");
        BigInteger current = new BigInteger("1");
        BigInteger tmp;


        int index = 2;

        while (Counter.countCondition(current.toString().length() < TARGET_DIGIT_COUNT)) {
            Counter.incrementLoopCount();
            index++;
            tmp = current;
            current = current.add(prev);
            prev = tmp;
        }
        System.out.println(index);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(ThousandDigitFibNumber::solution);
    }
}
