package Problems._0001To00025._0003_Largest_Prime_Factor;

import Helpers.PrimeHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.util.ArrayList;

public class LargestPrimeFactor {
    private static final long questionNumber = 600851475143L;
    public static void getLargestPrimeFactorEfficient() {
        ArrayList<Long> primeFactors = PrimeHelper.getPrimeFactors(questionNumber);
        System.out.println(primeFactors.getLast());
    }

    public static void getLargestPrimeFactorNaive() {
        ArrayList<Integer> primeFactors = new ArrayList<>();
        long sqrtNumber = (long) Math.sqrt(questionNumber);
        for (int i = 3; Counter.countCondition(i <= sqrtNumber); i += 2) {
            Counter.incrementLoopCount();
            if (Counter.countCondition(PrimeHelper.isPrime(i) && questionNumber % i == 0)) {
                primeFactors.add(i);
            }
        }
        System.out.println(primeFactors.getLast());
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(LargestPrimeFactor::getLargestPrimeFactorNaive);
        RunInfo.executeWithInfo(LargestPrimeFactor::getLargestPrimeFactorEfficient);
    }
}
