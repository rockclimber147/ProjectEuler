package Problems._0001To00025._0010_Summation_Of_Primes;

import Helpers.PrimeHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.util.ArrayList;

public class SummationOfPrimes {
    private static final int max = 2000000;
    public static void solutionNaive() {
        long sum = 2;
        for (int i = 3; Counter.countCondition(i < max); i += 2) {
            Counter.incrementLoopCount();
            if (Counter.countCondition(PrimeHelper.isPrime(i))) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void solutionSieve() {
        ArrayList<Long> primeList = PrimeHelper.getPrimesBelowNumber(max);
        long sum = 0;
        for (int i = 0; Counter.countCondition(i < primeList.size()); i++) {
            Counter.incrementLoopCount();

            sum += primeList.get(i);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(SummationOfPrimes::solutionNaive);
        RunInfo.executeWithInfo(SummationOfPrimes::solutionSieve);
    }
}
