package questionFormatter;

import Helpers.FileHelper;

import java.util.HashMap;
import java.util.Map;

public class QuestionFormatter {
    private static final HashMap<String, String> extraFormatting = createMap();

    private static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put("$", "");
        map.put("\\times", "x");
        map.put("\\ne", "!=");
        map.put("\\cdots", "...");

        return map;
    }
    public static void formatQuestion(final String filePath) {
        String contents = FileHelper.getFileContentsAsString(filePath);
        contents = stripHTML(contents);
        contents = replaceExtraFormatting(contents);
        FileHelper.writeStringToTextFile(contents, filePath);
    }

    private static String replaceExtraFormatting(final String input) {
        String output = input;

        for (Map.Entry<String, String> pair : extraFormatting.entrySet()) {
            output = output.replaceAll(pair.getKey(), pair.getValue());
        }

        return output;
    }

    private static String stripHTML(final String input) {

        return input.replaceAll("<[^>]*>", "");
    }

    public static void main(String[] args) {
        formatQuestion("src/Problems/_0024_Lexicographic_Permutations/Question.txt");
    }
}
