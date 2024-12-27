package Problems._0021_Amicable_Numbers;

import Helpers.PatternHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.util.HashSet;

public class AmicableNumbers {
    private static final int target = 10000;

    public static void solution() {
        HashSet<Integer> amicableNumbers = new HashSet<>();

        for (int i = 3; Counter.countCondition(i < target); i++) {
            Counter.incrementLoopCount();
            if (Counter.countCondition(!amicableNumbers.contains(i))) {
                int amicableNumber = PatternHelper.getAmicableNumber(i);
                if (Counter.countCondition(amicableNumber > 0 && amicableNumber < target)) {
                    amicableNumbers.add(i);
                    amicableNumbers.add(amicableNumber);
                }
            }
        }

        int sum = 0;
        for (int number : amicableNumbers) {
            sum += number;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(AmicableNumbers::solution);
    }
}
