package Problems._0015_Lattice_Paths;

import Helpers.CombinatoricsHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.util.Arrays;

public class LatticePaths {
    private static final int verticalPaths = 20;
    private static final int horizontalPaths = 20;

    public static void solutionCombinatorics() {
        long solution = CombinatoricsHelper.choose(verticalPaths + horizontalPaths, horizontalPaths);
        System.out.println(solution);
    }

    public static void solutionDynamicProgramming() {
        long[] currentRow = new long[horizontalPaths + 1];
        Arrays.fill(currentRow, 1);
        for (int i = 1; Counter.countCondition(i <= verticalPaths); i++) {
            Counter.incrementLoopCount();
            for(int j = 1; Counter.countCondition(j < currentRow.length); j++) {
                Counter.incrementLoopCount();
                currentRow[j] += currentRow[j - 1];
            }
        }
        System.out.println(currentRow[currentRow.length - 1]);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(LatticePaths::solutionCombinatorics);
        RunInfo.executeWithInfo(LatticePaths::solutionDynamicProgramming);
    }
}
