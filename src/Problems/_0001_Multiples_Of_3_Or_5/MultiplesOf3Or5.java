package Problems._0001_Multiples_Of_3_Or_5;

import Stats.Counter;
import Stats.RunInfo;

public class MultiplesOf3Or5 extends RunInfo {
    private static int limit = 1000;
    private static int total = 0;
    public static void reset(){
        total = 0;
    }

    public static void setLimit(int newLimit) {
        limit = newLimit;
    }
    public static void printSumOfMultiplesOf3Or5Below1000BruteForce() {
        reset();
        Counter.forLoop(0, n -> n < limit, n -> n + 1, MultiplesOf3Or5::addIfMultipleOf3Or5);
        System.out.println(total);
    }

    public static void addIfMultipleOf3Or5(int number) {
        if (Counter.checkCondition(number, n -> n % 3 == 0 || n % 5 == 0)){
            addToTotal(number);
        }
    }

    public static void addToTotal(int number) {
        total += number;
    }

    public static void printMultiplesOf3Or5Below1000Counting() {
        reset();
        Counter.forLoop(0, n -> n < limit, n -> n + 3, MultiplesOf3Or5::addToTotal);

        Counter.forLoop(0, n -> n < limit, n -> n + 5, MultiplesOf3Or5::addIfNotMultipleOf3);
        System.out.println(total);
    }

    public static void addIfNotMultipleOf3(int number) {
        if (Counter.checkCondition(number, n -> n % 3 != 0)){
            addToTotal(number);
        }
    }

    public static void main(String[] args) {
        setLimit(1000);
        executeWithInfo(MultiplesOf3Or5::printSumOfMultiplesOf3Or5Below1000BruteForce);
        executeWithInfo(MultiplesOf3Or5::printMultiplesOf3Or5Below1000Counting);
    }
}


