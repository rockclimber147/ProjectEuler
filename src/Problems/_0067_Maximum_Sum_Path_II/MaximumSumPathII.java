package Problems._0067_Maximum_Sum_Path_II;

import Problems._0001To00025._0018_Maximum_Path_Sum_I.MaximumPathSumI;
import Stats.RunInfo;

public class MaximumSumPathII {
    private static final String filePath = "src/Problems/_0067_Maximum_Sum_Path_II/triangle.txt";

    public static void main(String[] args) {
        MaximumPathSumI.init(filePath);
        RunInfo.executeWithInfo(MaximumPathSumI::solution);
    }
}
