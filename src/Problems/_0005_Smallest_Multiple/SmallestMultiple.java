package Problems._0005_Smallest_Multiple;

import Helpers.PrimeHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SmallestMultiple {
    private static int maxDivisor = 20;
    public static void smallestMultipleNaive() {
        long number = 1;
        while(Counter.countCondition(!hasAllDivisors(number))) {
            Counter.incrementLoopCount();
            number++;
        }
        System.out.println(number);
    }

    public static boolean hasAllDivisors(long number) {
        for (int i = 2; Counter.countCondition(i <= maxDivisor); i++) {
            Counter.incrementLoopCount();
            if (Counter.countCondition(number % i != 0)) {
                return false;
            }
        }
        return true;
    }

    public static void smallestMultiplePrimeFactors() {
        long lowestNumberWithAllFactors = 1;
        ArrayList<ArrayList<Long>> allFactors = new ArrayList<>();
        HashMap<Long, Long> highestPrimePowers = new HashMap<>();
        ArrayList<Long> primesBelowMaxDivisor = PrimeHelper.getPrimesBelowNumber(maxDivisor);

        for (int i = 2; Counter.countCondition(i <= maxDivisor); i++) {
            Counter.incrementLoopCount();
            allFactors.add(PrimeHelper.getPrimeFactors(i));
        }

        for (int i = 0; Counter.countCondition(i < primesBelowMaxDivisor.size()); i++) {
            Counter.incrementLoopCount();

            long currentPrime = primesBelowMaxDivisor.get(i);
            populatePrimeCounts(currentPrime, highestPrimePowers, allFactors);
        }

        for (Map.Entry<Long, Long> entry : highestPrimePowers.entrySet()) {
            Counter.incrementLoopCount();
            Counter.incrementConditionalCount();

            lowestNumberWithAllFactors *= (long) Math.pow(entry.getKey(), entry.getValue());
        }

        System.out.println(lowestNumberWithAllFactors);
    }

    private static void populatePrimeCounts(long primeToSearch,
                                            HashMap<Long, Long> counts,
                                            ArrayList<ArrayList<Long>> primeFactorList) {
        long maxCount = 0;

        for (int i = 0; Counter.countCondition(i < primeFactorList.size()); i++) {
            Counter.incrementLoopCount();

            int currentCount = 0;
            ArrayList<Long> currentList = primeFactorList.get(i);
            for (int j = 0; Counter.countCondition(j < currentList.size()); j++) {
                Counter.incrementLoopCount();

                if (Counter.countCondition(primeToSearch == currentList.get(j))) {
                    currentCount++;
                }
            }
            if (Counter.countCondition(currentCount > maxCount)) {
                maxCount = currentCount;
            }
        }

        if (Counter.countCondition(maxCount != 0)) {
            counts.put(primeToSearch, maxCount);
        }
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(SmallestMultiple::smallestMultipleNaive);
        RunInfo.executeWithInfo(SmallestMultiple::smallestMultiplePrimeFactors);
    }
}
