package Helpers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHelper {
    public static String getFileContentsAsString(final String filePath) {
        String content = null;
        try {
            Scanner scanner = new Scanner(Paths.get(filePath), StandardCharsets.UTF_8);
            content = scanner.useDelimiter("\\A").next();
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return content;
    }

    public static int[][] getFileContentsAsGrid(final String filePath,
                                              final String rowDelimiter,
                                              final String colDelimiter) {
        String contents = getFileContentsAsString(filePath);
        String[] rows = contents.split(rowDelimiter);
        int[][] grid = new int[rows.length][];
        int rowIndex = 0;
        for (String row : rows) {
            String[] cols = row.split(colDelimiter);
            int[] formattedCols = new int[cols.length];
            for (int i = 0; i< cols.length; i++) {
                formattedCols[i] = Integer.parseInt(cols[i].replaceAll("\\s", ""));
            }
            grid[rowIndex] = formattedCols;
            rowIndex++;
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = getFileContentsAsGrid("src/Problems/_0011_Largest_Product_In_A_Grid/Grid.txt", "\n", " ");
        for (int[] row : grid) {
            for (int num : row) {
                if (num < 10) System.out.print("0");
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
