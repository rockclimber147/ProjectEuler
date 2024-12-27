package Helpers;

import Stats.Counter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FactorHelper {
    public static ArrayList<Long> getAllFactorsNaive(long number) {
        ArrayList<Long> factors = new ArrayList<>();
        for (long i = 1; Counter.countCondition(i <= Math.sqrt(number)); i++) {
            Counter.incrementLoopCount();
            if (Counter.countCondition(number % i == 0)) {
                factors.add(i);
                factors.add(number / i);
            }
        }
        return factors;
    }

    public static Set<Long> getAllFactorsFromPrimeFactors(long number) {
        Set<Long> factors = new HashSet<>();
        ArrayList<Long> primeFactors = PrimeHelper.getPrimeFactors(number);
        factors.add(1L);

        for (int i = 0; Counter.countCondition(i < primeFactors.size()); i++) {
            long prime = primeFactors.get(i);
            Counter.incrementLoopCount();

            List<Long> newFactors = new ArrayList<>();

            List<Long> factorSetList = new ArrayList<>(factors);
            for (int j = 0; Counter.countCondition(j < factorSetList.size()); j++) {
                Counter.incrementLoopCount();

                long existingFactor = factorSetList.get(j);
                newFactors.add(existingFactor * prime);
            }
            factors.addAll(newFactors);
        }

        return factors;
    }

    public static int getFactorSum(int input) {
        ArrayList<Long> factors = new ArrayList<>(getAllFactorsFromPrimeFactors(input));
        int sum = 0;
        for (int i = 0; Counter.countCondition(i < factors.size()); i++) {
            Counter.incrementLoopCount();
            sum += factors.get(i);
        }
        return sum;
    }
}
