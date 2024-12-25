package Helpers;

import Stats.Counter;

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

    public static void main(String[] args) {
        System.out.println(choose(40, 20));
    }
}
