package Problems._0026To0050._0026_Reciprocal_Cycles._0033_Digit_Cancelling_Fractions;

import Helpers.FractionHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.util.*;

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
                if (
                        denominator % 10 != 0
                                && (double)numerator / denominator == (double)(numerator / 10) / (denominator % 10)
                                && numerator % 10 == denominator / 10
                                && denominator % 11 > 0
                ){
                    final_numerator *= numerator;
                    final_denominator *= denominator;
                }
            }
        }
        System.out.println(FractionHelper.reduce(final_numerator, final_denominator)[1]);
    }

    public static void solution2() {
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 10; i < 100; i++) {
            buckets[i % 10].add(i);
            buckets[i / 10].add(i);
        }

        int final_numerator = 1;
        int final_denominator = 1;

        for (int i = 1; i < buckets.length; i++) {
            ArrayList<Integer> list = buckets[i];
            for (int j = 0; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    int numerator = list.get(j);
                    int denominator = list.get(k);
                    if (
                            denominator % 10 != 0
                            && (double) numerator / denominator == (double) (numerator / 10) / (denominator % 10)
                            && numerator % 10 == denominator / 10
                            && denominator % 11 > 0
                    ){
                        final_numerator *= numerator;
                        final_denominator *= denominator;
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
