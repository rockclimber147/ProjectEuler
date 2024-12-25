package Helpers;

import Stats.Counter;

import java.util.ArrayList;

public class PrimeHelper {

    public static ArrayList<Long> getPrimesBelowNumber(int number) {
        ArrayList<Long> primes = new ArrayList<>();
        boolean[] compositesBelowInput = new boolean[number];
        int sqrtNumber = (int) Math.sqrt(number) ;

        for (int i = 2; Counter.countCondition(i <= sqrtNumber); i++) {
            Counter.incrementLoopCount();
            if (Counter.countCondition(!compositesBelowInput[i])){
                // Smaller multiples of i will already have been marked
                for (int j = i * i; Counter.countCondition(j < number); j += i) {
                    Counter.incrementLoopCount();
                    compositesBelowInput[j] = true;
                }
            }
        }

        for (long i = 2; Counter.countCondition(i < number); i++) {
            Counter.incrementLoopCount();
            if(Counter.countCondition(!compositesBelowInput[(int) i])) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static int getNthPrimeNumber(final int number) {
        int count = 0;
        int current = 1;

        while (Counter.countCondition(count < number)) {
            Counter.incrementLoopCount();
            current++;
            if (isPrime(number)) {
                count++;
            }
        }

        return current;
    }

    public static boolean isPrime(final long number) {
        if (Counter.countCondition(number == 1)) {
            return false;
        } else if (Counter.countCondition(number < 4)) {
            return true;
        } else if (Counter.countCondition(number % 2 == 0)) {
            return false;
        } else if (Counter.countCondition(number < 9)) {
            return true;
        } else if (Counter.countCondition(number % 3 == 0)) {
            return false;
        }
        long sqrtNumber = (long) Math.sqrt(number);
        long current = 5;
        while(Counter.countCondition(current <= sqrtNumber)) {
            Counter.incrementLoopCount();
            if (Counter.countCondition(number % current == 0 || number % (current + 2) == 0)) {
                return false;
            }
            current += 6;
        }
        return true;
    }

    public static ArrayList<Long> getPrimeFactors(final long number) {
        ArrayList<Long> factorsList = new ArrayList<>();
        long current = number;

        while (Counter.countCondition(current % 2 == 0)) {
            Counter.incrementLoopCount();
            factorsList.add(2L);
            current /= 2;
        }
        long sqrtCurrent = (long) Math.sqrt(current);
        for (long i = 3; Counter.countCondition(i <= sqrtCurrent); i += 2) {
            Counter.incrementLoopCount();
            while (Counter.countCondition(current % i == 0)) {
                Counter.incrementLoopCount();
                factorsList.add(i);
                current /= i;
                sqrtCurrent = (long) Math.sqrt(current);
            }
        }

        if (Counter.countCondition(current > 2)) {
            factorsList.add(current);
        }

        return factorsList;
    }

    public static void main(String[] args) {
        System.out.println(getPrimeFactors(9));
    }
}
