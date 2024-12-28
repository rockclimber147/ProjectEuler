package Problems._0024_Lexicographic_Permutations;

import Stats.Counter;
import Stats.RunInfo;

public class LexicographicPermutations {
    private static int count = 0;
    private static final int LIMIT = 1000000;
    private static final int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static void solution() {
        do {
            count++;
            if (count == LIMIT) {
                printArray();
                return;
            }
        } while (nextPermutation());
    }

    static boolean nextPermutation() {
        int i = array.length - 2;
        while (Counter.countCondition(i >= 0 && array[i] >= array[i + 1])) {
            Counter.incrementLoopCount();
            i--;
        }

        if (Counter.countCondition(i < 0)) {
            return false;
        }

        int j = array.length - 1;
        while (Counter.countCondition(array[j] <= array[i])) {
            Counter.incrementLoopCount();
            j--;
        }

        swap(i, j);

        reverse(i + 1, array.length - 1);
        return true;
    }

    static void reverse(int start, int end) {
        while (Counter.countCondition(start < end)) {
            Counter.incrementLoopCount();
            swap(start, end);
            start++;
            end--;
        }
    }

    private static void swap(final int index1, final int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray() {
        for (int digit: array) {
            System.out.print(digit);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(LexicographicPermutations::solution);
    }
}
