package Problems._0026To0050._0026_Reciprocal_Cycles._0027_quadratic_primes;

import Helpers.PrimeHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class QuadraticPrimes {
    static int maxAbsVal = 1000;

    public static void solution() {
        int bestA = maxAbsVal + 1;
        long bestB = maxAbsVal + 1;
        long maxN = 0;
        ArrayList<Long> bValues = PrimeHelper.getPrimesBelowNumber(maxAbsVal + 1);
        Set<Long> primeCache = new HashSet<>(PrimeHelper.getPrimesBelowNumber(100000));
        for (int a = -maxAbsVal; a <= maxAbsVal; a++) {
            for (long b: bValues) {
                long n = -1;
                while (true) {
                    n++;
                    long number = n * n + a * n + b;
                    if (number < 0) {
                        break;
                    }
                    if (!primeCache.contains(number)) {
                        if (PrimeHelper.isPrime(number)) {
                            primeCache.add(number);
                        } else {
                            break;
                        }
                    }
                    if (n >= maxN) {
                        maxN = n;
                        bestA = a;
                        bestB = b;
                    }
                }
            }
        }
        System.out.println(bestA * bestB);
    }

    public static void main(String[] args) {
        solution();
    }
}
