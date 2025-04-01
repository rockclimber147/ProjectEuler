package Problems._0001To00025._0016_Power_Digit_Sum;

import Helpers.PatternHelper;
import Stats.RunInfo;

import java.math.BigInteger;

public class PowerDigitSum {
    private static final int powerTarget = 1000;

    public static void solutionBigInt() {
        BigInteger base = new BigInteger("2");
        BigInteger result = base.pow(powerTarget);
        int total = PatternHelper.sumOfDigits(result.toString());
        System.out.println(total);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(PowerDigitSum::solutionBigInt);
    }
}
