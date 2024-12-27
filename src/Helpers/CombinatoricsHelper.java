package Helpers;

import Stats.Counter;

import java.math.BigInteger;

public class CombinatoricsHelper {

    public static long choose(int total, int toChoose) {
        int smaller = Math.min(toChoose, total - toChoose);
        long answer = 1;

        for (int i = 0; Counter.countCondition(i < smaller); i++) {
            Counter.incrementLoopCount();
            answer *= (total - i);
            answer /= (i + 1);
        }

        return answer;
    }

    public static BigInteger factorial(int input) {
        BigInteger factorial = new BigInteger(input + "");
        for (int i = input - 1; Counter.countCondition(i > 1); i--) {
            Counter.incrementLoopCount();
            factorial = factorial.multiply(new BigInteger(i + ""));
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(choose(40, 20));
    }
}
