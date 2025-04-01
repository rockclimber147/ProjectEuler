package Helpers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FractionHelper {
    public static long[] reduce(int numerator, int denominator){
        long[] fraction = {numerator, denominator};

        Set<Long> numeratorFactors = FactorHelper.getAllFactorsFromPrimeFactors(numerator);
        Set<Long> denominatorFactors = FactorHelper.getAllFactorsFromPrimeFactors(denominator);
        Set<Long> overlap = new HashSet<>(numeratorFactors);
        overlap.retainAll(denominatorFactors);

        if (!overlap.isEmpty()) {
            long max = Collections.max(overlap);
            fraction[0] /= max;
            fraction[1] /= max;
        }
        return fraction;
    }
}
