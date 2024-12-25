package Problems._0008_Largest_Product_in_a_Series;

import Helpers.FileHelper;
import Stats.Counter;
import Stats.RunInfo;

import java.io.IOException;

public class LargestProductInASeries {
    private static String fileName = "src/Problems/_0008_Largest_Product_in_a_Series/number.txt";
    private static final int CHAR_INT_OFFSET = 48;
    private static char[] chars;
    private static int numbersToRead = 13;

    private static boolean init() {
        String content = FileHelper.getFileContentsAsString(fileName);
        if (content == null) {
            return false;
        }
        chars = content.replaceAll("\\s", "").toCharArray();
        return true;
    }

    public static void solutionMoreLooping() {
        long longestProductSoFar = 0;

        int minIndex = 0;
        int maxIndex = numbersToRead - 1;

        while (Counter.countCondition(maxIndex < chars.length)) {
            Counter.incrementLoopCount();
            long currentProduct = 1;
            for (int i = minIndex; Counter.countCondition(i <= maxIndex); i++) {
                Counter.incrementLoopCount();

                currentProduct *= (chars[i] - CHAR_INT_OFFSET);
            }

            if (Counter.countCondition(currentProduct > longestProductSoFar)) {
                longestProductSoFar = currentProduct;
            }

            minIndex++;
            maxIndex++;
        }

        System.out.println(longestProductSoFar);
    }

    private static int minIndex;
    private static int maxIndex;
    private static int currentProduct;
    private static int largestProduct;

    private static void reset() {
        minIndex = 0;
        maxIndex = 0;
        currentProduct = 1;
        largestProduct = 0;
    }
    public static void solutionLessLooping() {
        reset(); // Initialize indices and product variables
        initializeAtIndex(0); // Set up the initial sliding window

        while (Counter.countCondition(maxIndex < chars.length)) {
            maxIndex++; // Move the sliding window forward

            if (Counter.countCondition(maxIndex >= chars.length)) {
                break;
            }

            int currentValue = chars[maxIndex] - CHAR_INT_OFFSET;

            if (Counter.countCondition(currentValue != 0)) {
                currentProduct *= currentValue; // Add current value to the product

                // Check if the window size exceeds the desired length
                if (maxIndex - minIndex + 1 > numbersToRead) {
                    currentProduct /= (chars[minIndex] - CHAR_INT_OFFSET);
                    minIndex++; // Move the window start forward
                }

                // Update the largest product if the current one is greater
                if (Counter.countCondition(currentProduct > largestProduct)) {
                    largestProduct = currentProduct;
                }
            } else {
                // Reset the sliding window if a zero is encountered
                initializeAtIndex(maxIndex + 1);
            }
        }

        System.out.println(largestProduct);
    }

    private static void initializeAtIndex(int index) {
        minIndex = index; // Reset the start of the window
        maxIndex = index - 1; // Reset the end of the window
        currentProduct = 1; // Reset the product

        // Build the initial window
        while (Counter.countCondition(maxIndex < minIndex + numbersToRead - 1 && maxIndex < chars.length - 1)) {
            maxIndex++;
            if (Counter.countCondition(maxIndex >= chars.length)) {
                break;
            }

            int currentValue = chars[maxIndex] - CHAR_INT_OFFSET;

            if (Counter.countCondition(currentValue == 0)) {
                // If zero is found, reset and exit early
                initializeAtIndex(maxIndex + 1);
                return;
            } else {
                currentProduct *= currentValue;
            }
        }

        // Update the largest product after initialization
        if (Counter.countCondition(currentProduct > largestProduct)) {
            largestProduct = currentProduct;
        }
    }

    public static void main(String[] args) throws IOException {
        if (init()) {
            RunInfo.executeWithInfo(LargestProductInASeries::solutionMoreLooping);
            RunInfo.executeWithInfo(LargestProductInASeries::solutionLessLooping);
        }
    }
}
