package Problems._0023_Non_Abundant_Sums;

import Helpers.FactorHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NonAbundantSums {
    private static final int smallestAbundantNumber = 12;
    private static final int target = 28123;

    public static void solution() {
        ArrayList<Integer> abundantNumbers = getAbundantNumbersBelowTarget();
        long sumOfNumbersToTarget = (target * (target + 1)) / 2;
        long sumOfAllPairsOfAbundantNumbers = getSumOfAllPairs(abundantNumbers);

        System.out.println(sumOfNumbersToTarget - sumOfAllPairsOfAbundantNumbers);
    }

    private static ArrayList<Integer> getAbundantNumbersBelowTarget() {
        ArrayList<Integer> abundantNumbers = new ArrayList<>();
        for (int i = smallestAbundantNumber; Counter.countCondition(i <= target); i++) {
            Counter.incrementLoopCount();

            int sumOfProperDivisors = FactorHelper.getSumOfProperDivisors(i);
            if (Counter.countCondition(sumOfProperDivisors > i)) {
                abundantNumbers.add(i);
            }
        }
        return abundantNumbers;
    }
    private static long getSumOfAllPairs(ArrayList<Integer> numbers) {
        long sum = 0;
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; Counter.countCondition(i < numbers.size()); i++) {
            Counter.incrementLoopCount();
            for (int j = 0; Counter.countCondition(j < numbers.size()); j++) {
                Counter.incrementLoopCount();

                int currentSum = numbers.get(i) + numbers.get(j);
                if (Counter.countCondition(currentSum <= target)) {
                    sums.add(currentSum);
                }
            }
        }
        for (int uniqueSum: sums) {
            sum += uniqueSum;
        }
        return sum;
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(NonAbundantSums::solution);
    }
}
