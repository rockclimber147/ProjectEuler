package Problems._0022_Names_Scores;

import Helpers.FileHelper;
import Helpers.Sorting;
import Stats.Counter;
import Stats.RunInfo;

import java.util.ArrayList;
import java.util.Arrays;

public class NamesScores {
    private static final int ASCII_INT_OFFSET = 64;
    private static final String filePath = "src/Problems/_0022_Names_Scores/names.txt";

    public static void solution() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList(getNames()));
        Sorting.mergeSort(names, String::compareTo);
        long sum = getSumOFNamesScores(names);
        System.out.println(sum);
    }
    private static String[] getNames() {
        String contents = FileHelper.getFileContentsAsString(filePath);
        contents = contents.replaceAll("\"", "");
        return contents.split(",");
    }

    private static int getSumOFNamesScores(ArrayList<String> names) {
        int sum = 0;

        for (int i = 0; Counter.countCondition(i < names.size()); i++) {
            sum += (i + 1) * getStringAlphaScore(names.get(i));
            System.out.println((i + 1) + " " + names.get(i) + " " + ((i + 1) * getStringAlphaScore(names.get(i))));
        }
        return sum;
    }

    private static int getStringAlphaScore(String input) {
        int sum = 0;
        for (int i = 0; Counter.countCondition(i < input.length()); i++) {
            Counter.incrementLoopCount();
            sum += input.charAt(i) - ASCII_INT_OFFSET;
        }
        return sum;
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(NamesScores::solution);
    }
}
