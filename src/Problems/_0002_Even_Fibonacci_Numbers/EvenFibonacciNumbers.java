package Problems._0002_Even_Fibonacci_Numbers;

import Helpers.FibonacciHelper;
import Stats.Counter;
import Stats.RunInfo;

public class EvenFibonacciNumbers {
    private final static int maxFibValue = 4000000;
    private static int currentFibNumber = 0;
    private static int fibIndex = 1;
    private static int sum = 0;
    private static final FibonacciHelper fib = new FibonacciHelper();

    private static void reset() {
        fib.reset();
        sum = 0;
        currentFibNumber = 0;
        fibIndex = 1;
    }

    public static void printSumOfEvenFibNumbersBelowMax() {
        reset();
        Counter.forLoop(1, n -> currentFibNumber < maxFibValue, n -> fibIndex + 1, EvenFibonacciNumbers::processNthFibNumberNaive);
        System.out.println(sum);
    }

    public static void processNthFibNumberNaive() {
        currentFibNumber = fib.getNthFibonacciNumber(fibIndex);
        if (Counter.checkCondition(currentFibNumber, n -> n % 2 == 0)) {
            sum += currentFibNumber;
        }
        fibIndex++;
    }

    public static void printSumOfEvenFibNumbersBelowMaxLessLooping() {
        reset();
        Counter.forLoop(1, n -> currentFibNumber < maxFibValue, n -> fibIndex + 1, EvenFibonacciNumbers::processNthFibNumberLessLooping);
        System.out.println(sum);
    }

    public static void processNthFibNumberLessLooping() {
        currentFibNumber = fib.getNext();
        sum += ((currentFibNumber + 1) % 2) * currentFibNumber;
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(EvenFibonacciNumbers::printSumOfEvenFibNumbersBelowMax);
        reset();
        RunInfo.executeWithInfo(EvenFibonacciNumbers::printSumOfEvenFibNumbersBelowMaxLessLooping);
    }

}
