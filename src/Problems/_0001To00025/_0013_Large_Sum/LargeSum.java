package Problems._0001To00025._0013_Large_Sum;

import Helpers.FileHelper;
import Stats.Counter;
import Stats.RunInfo;

public class LargeSum {
    private static final String filePath = "src/Problems/_0013_Large_Sum/Numbers.txt";

    private static String[] numbersArray;

    private static void init() {
        numbersArray = FileHelper.getFileContentsAsString(filePath).split("\\s+");
    }

    private static void solution() {
        init();
        long total = 0;
        for (int i = 0; Counter.countCondition(i < numbersArray.length); i++) {
            Counter.incrementLoopCount();
            total += Long.parseLong(numbersArray[i].substring(0, 11));
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(LargeSum::solution);
    }
}
