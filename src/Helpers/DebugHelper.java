package Helpers;

public class DebugHelper {
    public static void printNestedArray(int[][] nestedArray) {
        for (int[] array : nestedArray) {
            printArray(array);
        }
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }
}
