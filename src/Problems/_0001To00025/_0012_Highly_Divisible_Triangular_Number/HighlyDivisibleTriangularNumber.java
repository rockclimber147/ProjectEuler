package Problems._0001To00025._0012_Highly_Divisible_Triangular_Number;

import Helpers.FactorHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.util.Set;

public class HighlyDivisibleTriangularNumber {
    private static final int factorCount = 500;


    public static void solutionNaive() {
        long currentTriangleNumber = 1;
        int numberForNextTriangularNumber = 2;

        while (Counter.countCondition(FactorHelper.getAllFactorsNaive(currentTriangleNumber).size() < factorCount)) {
            currentTriangleNumber += numberForNextTriangularNumber;
            numberForNextTriangularNumber++;
        }
        System.out.println(currentTriangleNumber);
    }
    public static void solutionWithPrimeFactorization() {
        long currentTriangleNumber = 1;
        int numberForNextTriangularNumber = 2;
        Set<Long> totalFactors = FactorHelper.getAllFactorsFromPrimeFactors(currentTriangleNumber);
        while (Counter.countCondition(totalFactors.size() < factorCount)) {
            Counter.incrementLoopCount();
            currentTriangleNumber += numberForNextTriangularNumber;
            numberForNextTriangularNumber++;
            totalFactors = FactorHelper.getAllFactorsFromPrimeFactors(currentTriangleNumber);
        }
        System.out.println(currentTriangleNumber);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(HighlyDivisibleTriangularNumber::solutionNaive);
        RunInfo.executeWithInfo(HighlyDivisibleTriangularNumber::solutionWithPrimeFactorization);
    }
}
