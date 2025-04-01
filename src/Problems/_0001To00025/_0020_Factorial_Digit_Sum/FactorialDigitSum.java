package Problems._0001To00025._0020_Factorial_Digit_Sum;

import Helpers.CombinatoricsHelper;
import Helpers.PatternHelper;
import Stats.RunInfo;

public class FactorialDigitSum {
    private static final int TARGET_NUMBER = 100;

    public static void solution() {
        String digits = CombinatoricsHelper.factorial(TARGET_NUMBER).toString();
        int sumOfDigits = PatternHelper.sumOfDigits(digits);
        System.out.println(sumOfDigits);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(FactorialDigitSum::solution);
    }
}
