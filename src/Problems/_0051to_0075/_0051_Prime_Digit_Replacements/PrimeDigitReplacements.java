package Problems._0051to_0075._0051_Prime_Digit_Replacements;


import Helpers.PatternHelper;
import Helpers.PrimeHelper;
import Stats.RunInfo;

import java.util.ArrayList;
import java.util.HashSet;

public class PrimeDigitReplacements {
    private static ArrayList<Long> candidates;
    private static HashSet<Long> primes;
    private static final long start = 56003;

    private static void init() {
        candidates = PrimeHelper.getPrimesBelowNumber(10000000);
        primes = new HashSet<>(candidates);
    }
    public static void solution() {
        init();
        int index = candidates.indexOf(start);
        while (index < candidates.size()) {
            Long current = candidates.get(index);
            if (maxPrimeFamily(current) == 8) {
                System.out.println(current);
                return;
            }
            index++;
        }
    }

    static int maxPrimeFamily(long number) {
        int max = 0;
        long remainder = number / 10;
        int digits = (int) Math.log10(remainder);
        int maxMask = (int) Math.pow(2, digits + 1) - 1;
        for (long mask = 1; mask <= maxMask; mask++) {
            long replacements = PatternHelper.binaryRepresentationAsDecimal(mask) * 10;
            long prepared = prepareNumber(number, mask);
            int primes = nPrimeFamily(number, prepared, replacements);
            if (primes > max) max = primes;
        }
        return max;
    }

    static int nPrimeFamily(long original, long prepared, long replacements) {
        int primeCount = 0;
        for (int i = 0; i < 10; i++) {
            if (prepared >= original && primes.contains(prepared)) primeCount++;
            prepared += replacements;
        }
        if (primeCount == 8) System.out.println("mask: " + replacements);
        return primeCount;
    }

    private static long prepareNumber(long number, long mask) {
        int place = 2;
        while (mask > 0) {
            if ((mask & 1) == 1) {
                number = PatternHelper.setNthDigitToZero(number, place);
            }
            mask >>= 1;
            place++;
        }
        return number;
    }

    public static void main(String[] args) {
        RunInfo.showRuntimeMs(PrimeDigitReplacements::solution);
    }
}
