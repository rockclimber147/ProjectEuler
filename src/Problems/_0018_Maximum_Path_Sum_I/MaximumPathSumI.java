package Problems._0018_Maximum_Path_Sum_I;

import Helpers.FileHelper;
import Stats.Counter;
import Stats.RunInfo;

public class MaximumPathSumI {
    private static final String filePath = "src/Problems/_0018_Maximum_Path_Sum_I/Triangle.txt";
    private static int[][] triangle = FileHelper.getFileContentsAsGrid(filePath);

    public static void init(final String filePath) {
        triangle = FileHelper.getFileContentsAsGrid(filePath);
    }

    public static void solution() {
        for (int i = triangle.length - 2; Counter.countCondition(i >= 0); i--) {
            Counter.incrementLoopCount();
            for (int j = 0; Counter.countCondition(j < triangle[i].length); j++) {
                Counter.incrementLoopCount();
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        System.out.println(triangle[0][0]);
    }
    public static void main(String[] args) {
        init(filePath);
        RunInfo.executeWithInfo(MaximumPathSumI::solution);
    }
}
