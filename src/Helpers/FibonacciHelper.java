package Helpers;

import Stats.Counter;

public class FibonacciHelper {
//    private static int current = 1;
//    private static int prev = 1;

    private int current;
    private int prev;

    public FibonacciHelper() {
        this.reset();
    }

    public void reset() {
        this.current = 1;
        this.prev = 0;
    }

    public int getNthFibonacciNumber(final int number) {
        this.reset();
        Counter.forLoop(0, n -> n < number, n -> n + 1, this::getNext);
        return this.current;
    }

    public int getNext() {
        int tmp = this.current;
        this.current = this.current + this.prev;
        this.prev = tmp;
        return this.current;
    }

    public static void main(String[] args) {
        FibonacciHelper helper = new FibonacciHelper();
        System.out.println(helper.getNthFibonacciNumber(10));
    }
}
