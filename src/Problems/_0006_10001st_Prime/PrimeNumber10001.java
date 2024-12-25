package Problems._0006_10001st_Prime;

import Helpers.PrimeHelper;
import Stats.Counter;
import Stats.RunInfo;

public class PrimeNumber10001 {
    private static long nthPrimeToFind = 10001;
    public static void solution() {
        long numberToCheck = 1;
        int encounteredPrimes = 1;
        while (Counter.countCondition(encounteredPrimes < nthPrimeToFind)) {
            Counter.incrementLoopCount();
            numberToCheck += 2;

            if (Counter.countCondition(PrimeHelper.isPrime(numberToCheck))) {
                encounteredPrimes++;
            }
        }

        System.out.println(numberToCheck);
    }

    public static void solutionWithOldIsPrime() {
        long numberToCheck = 1;
        int encounteredPrimes = 1;
        while (Counter.countCondition(encounteredPrimes < nthPrimeToFind)) {
            Counter.incrementLoopCount();
            numberToCheck += 2;

            if (Counter.countCondition(isPrimeOld(numberToCheck))) {
                encounteredPrimes++;
            }
        }

        System.out.println(numberToCheck);
    }

    private static boolean isPrimeOld(long number) {
        long sqrtNumber = (long) Math.sqrt(number);
        for (int i = 2; Counter.countCondition(i <= sqrtNumber); i++) {
            Counter.incrementLoopCount();
            if (Counter.countCondition(number % i == 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(PrimeNumber10001::solutionWithOldIsPrime);
        RunInfo.executeWithInfo(PrimeNumber10001::solution);
    }
}
