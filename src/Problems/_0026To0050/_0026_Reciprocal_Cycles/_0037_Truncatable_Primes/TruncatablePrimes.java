package Problems._0026To0050._0026_Reciprocal_Cycles._0037_Truncatable_Primes;

import Helpers.PrimeHelper;
import Stats.RunInfo;

import java.util.*;

public class TruncatablePrimes {
    private static final int maxTruncatablePrimes = 11;
    private static ArrayList<Long> foundTruncatablePrimes;
    private static HashSet<Long> foundPrimes;
    private static ArrayList<Long> candidates;
    private static HashSet<Long> foundNonPrimes;

    private static void init() {
        foundTruncatablePrimes = new ArrayList<>();
        foundPrimes = new HashSet<>(Set.of(2L, 3L, 5L, 7L));
        foundNonPrimes = new HashSet<>(Set.of(1L));
        candidates = new ArrayList<>(List.of(2L, 3L, 5L, 7L));
    }
    public static void solution() {
        init();
        while (foundTruncatablePrimes.size() < maxTruncatablePrimes) {
            ArrayList<Long> newCandidates = new ArrayList<>();
            for (long number: candidates) {
                for (int toAppend = 1; toAppend < 10; toAppend += 2) {
                    long newNumber = number * 10 + toAppend;
                    if (checkPrime(newNumber)) {
                        newCandidates.add(newNumber);
                    }
                }
            }

            for (long candidate: candidates) {
                if (isTruncatablePrime(candidate)) {
                    foundTruncatablePrimes.add(candidate);
                }
            }
            candidates = newCandidates;
        }
        System.out.println();
        long sum = 0;
        for (long truncatablePrime: foundTruncatablePrimes) {
            sum += truncatablePrime;
            System.out.println(truncatablePrime);
        }
        System.out.println("sum: " + sum);
    }

    private static boolean checkPrime(long number) {
        if (foundPrimes.contains(number)) return true;
        if (foundNonPrimes.contains(number)) return false;
        if (PrimeHelper.isPrime(number)) {
            foundPrimes.add(number);
            return true;
        }
        foundNonPrimes.add(number);
        return false;
    }

    private static boolean isTruncatablePrime(long number) {
        if (number < 10) return false;
        String numString = number + "";
        for (int i = 1; i < numString.length(); i++) {
            long toCheck = Long.parseLong(numString.substring(i));
            if (!checkPrime(toCheck)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        RunInfo.showRuntimeMs(TruncatablePrimes::solution);
    }
}
