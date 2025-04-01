package Problems._0001To00025._0004_Largest_Palindrome_Product;

import Helpers.PatternHelper;
import Stats.Counter;
import Stats.RunInfo;

public class LargestPalindromeProduct {
    private static final int digitCount = 3;

    public static int getMaxNumber() {
        int number = 0;
        for (int i = 0; i < digitCount; i++) {
            number += (int) (9 * Math.pow(10, i));
        }
        return number;
    }

    public static int getMinNumber() {
        return (int) Math.pow(10, digitCount - 1);
    }

    public static void getLargestPalindromeProductCountingUp() {
        long maxProduct = 0;
        int factor1 = 0;
        int factor2 = 0;

        for (int i = getMinNumber(); Counter.countCondition(i <= getMaxNumber()); i++) {
            Counter.incrementLoopCount();
            for (int j = getMinNumber(); Counter.countCondition(j <= getMaxNumber()); j++) {
                long currentProduct = (long) i * j;
                if (Counter.countCondition(PatternHelper.isPalindrome(currentProduct)
                && currentProduct > maxProduct)) {
                    factor1 = i;
                    factor2 = j;
                    maxProduct = currentProduct;
                }
            }
        }
        System.out.println(factor1 + " * " + factor2 + " = " + maxProduct);
    }

    public static void getLargestPalindromeProductCountingDown() {
        int max = getMaxNumber();
        int min = getMinNumber();

        for (int sum = 2 * max; Counter.countCondition(sum >= 2 * min); sum--) {
            Counter.incrementLoopCount();
            for (int i = max; Counter.countCondition(i >= min); i--) {
                Counter.incrementLoopCount();
                int j = sum - i;
                long product = (long) i * j;
                if (Counter.countCondition(j >= min && j < max
                && PatternHelper.isPalindrome(product))) {
                    System.out.println(i + " * " + j + " = " + product);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(LargestPalindromeProduct::getLargestPalindromeProductCountingDown);
        RunInfo.executeWithInfo(LargestPalindromeProduct::getLargestPalindromeProductCountingUp);
    }
}
