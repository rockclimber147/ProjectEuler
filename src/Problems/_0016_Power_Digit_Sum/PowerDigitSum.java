package Problems._0016_Power_Digit_Sum;

import Helpers.PatternHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.math.BigInteger;

public class PowerDigitSum {
    private static final int powerTarget = 1000;

    public static void solutionBigInt() {
        BigInteger base = new BigInteger("2");
        BigInteger result = base.pow(powerTarget);
        char[] digits = result.toString().toCharArray();
        int total = 0;
        for (int i = 0; Counter.countCondition(i < digits.length); i++) {
            Counter.incrementConditionalCount();
            total += PatternHelper.charToInt(digits[i]);
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(PowerDigitSum::solutionBigInt);
    }
}
