package Problems._0033_Digit_Cancelling_Fractions;

import Helpers.FractionHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.util.*;
import java.util.stream.Collectors;

public class DigitCancellingFractions {
/*
We want to loop over two digit numerators and two digit denominators. If a digit cancelling fraction is found, it will
be valid regardless of the order of numerator and denominator (16/64 = 0.25 -> 1/4 = 0.25 and 64/16 = 4 -> 4/1 = 4)
When we find one, we also find the valid reciprocal so we only need to consider 2 digit denominators greater than the
numerator

There also exist trivial examples (10/40 = 0.25 and 1/4 = 0.25) which we should ignore. When a common digit is 0 we
skip the checks as it is trivial. Additionally, when there is more than one common digit then the cancelled fraction
would be blank after cancelling everything, so we only need to consider cases where the is one common digit and it is
not 0.

 */
    public static void solution() {
        int final_numerator = 1;
        int final_denominator = 1;
        for (int numerator = 10; numerator < 100; numerator++) {
            Counter.incrementLoopCount();
            for (int denominator = numerator + 1; denominator < 100; denominator++) {
                Counter.incrementLoopCount();
                String numStr = String.valueOf(numerator);
                String denStr = String.valueOf(denominator);
                Set<Character> commonDigits = numStr.chars()
                        .mapToObj(c -> (char) c)
                        .filter(c -> denStr.indexOf(c) >= 0)
                        .filter(c -> c != '0')
                        .collect(Collectors.toSet());

                if (commonDigits.size() == 1) {
                    char commonDigit = commonDigits.iterator().next();
                    String newNumStr = numStr.replace(String.valueOf(commonDigit), "");
                    String newDenStr = denStr.replace(String.valueOf(commonDigit), "");

                    if (!newNumStr.isEmpty() && !newDenStr.isEmpty()) {
                        int newNumerator = Integer.parseInt(newNumStr);
                        int newDenominator = Integer.parseInt(newDenStr);

                        if (
                                newDenominator > 0
                                && (double) numerator / denominator == (double) newNumerator / newDenominator) {
                            final_numerator *= numerator;
                            final_denominator *= denominator;
                        }
                    }
                }
            }
        }
        System.out.println(FractionHelper.reduce(final_numerator, final_denominator)[1]);
    }

    public static void solution2() {
        // Precompute buckets of numbers by their digits
        Map<Character, List<Integer>> digitBuckets = new HashMap<>();
        for (int i = 10; i < 100; i++) {
            Counter.incrementLoopCount();
            for (char digit : String.valueOf(i).toCharArray()) {
                Counter.incrementLoopCount();
                if (digit != '0') { // Skip numbers with '0'
                    digitBuckets.computeIfAbsent(digit, k -> new ArrayList<>()).add(i);
                }
            }
        }

        int final_numerator = 1;
        int final_denominator = 1;

        // Iterate only within buckets
        for (char digit : digitBuckets.keySet()) {
            Counter.incrementLoopCount();
            List<Integer> bucket = digitBuckets.get(digit);
            for (int i = 0; i < bucket.size(); i++) {
                Counter.incrementLoopCount();
                int numerator = bucket.get(i);
                for (int j = i + 1; j < bucket.size(); j++) {
                    Counter.incrementLoopCount();
                    int denominator = bucket.get(j);

                    // Ensure numerator < denominator
                    if (numerator < denominator) {
                        String numStr = String.valueOf(numerator).replace(String.valueOf(digit), "");
                        String denStr = String.valueOf(denominator).replace(String.valueOf(digit), "");

                        if (!numStr.isEmpty() && !denStr.isEmpty()) {
                            int newNumerator = Integer.parseInt(numStr);
                            int newDenominator = Integer.parseInt(denStr);

                            if (newDenominator > 0 && (double) numerator / denominator == (double) newNumerator / newDenominator) {
                                final_numerator *= numerator;
                                final_denominator *= denominator;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(FractionHelper.reduce(final_numerator, final_denominator)[1]);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(DigitCancellingFractions::solution);
        RunInfo.executeWithInfo(DigitCancellingFractions::solution2);
    }
}
