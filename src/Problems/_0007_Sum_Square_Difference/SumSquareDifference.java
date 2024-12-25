package Problems._0007_Sum_Square_Difference;

import Stats.Counter;
import Stats.RunInfo;

public class SumSquareDifference {
    private static long naturalNumberCount = 100;
    public static void solutionNaive() {
        long sum = 0;
        long sumSquares = 0;

        for (int i = 1; Counter.countCondition(i <= naturalNumberCount); i++) {
            Counter.incrementLoopCount();
            sum += i;
            sumSquares += i * i;
        }

        long solution = (sum * sum) - sumSquares;
        System.out.println(solution);
    }

    public static void solutionByFormula() {
        long sum = (naturalNumberCount * (naturalNumberCount + 1)) / 2;
        long sumSquared = sum * sum;

        long squareOfSums = ((2 * naturalNumberCount + 1) * (naturalNumberCount + 1) * naturalNumberCount) / 6;

        long solution = sumSquared - squareOfSums;
        System.out.println(solution);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(SumSquareDifference::solutionNaive);
        RunInfo.executeWithInfo(SumSquareDifference::solutionByFormula);
    }
}
