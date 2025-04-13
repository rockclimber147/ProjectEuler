package Helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class FileHelper {
    private static final String DEFAULT_COLUMN_DELIMITER = " ";
    private static final String DEFAULT_ROW_DELIMITER = "\n";
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
    public static void writeStringToTextFile(final String content, final String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, content.getBytes());
            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static int[][] getFileContentsAsGrid(final String filePath) {
        return getFileContentsAsGrid(filePath, DEFAULT_ROW_DELIMITER, DEFAULT_COLUMN_DELIMITER);
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

    public static Iterator<String> readFileLineByLine(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath)); // Create BufferedReader to read file
            return new Iterator<String>() {
                String currentLine;

                // Method to check if there's another line
                @Override
                public boolean hasNext() {
                    try {
                        currentLine = br.readLine();
                        return currentLine != null;  // If there's a next line, return true
                    } catch (IOException e) {
                        return false; // Return false if reading the file fails
                    }
                }

                // Method to get the next line
                @Override
                public String next() {
                    return currentLine;
                }
            };
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    public static Integer[][] readAdjacencyMatrixFromFile(String filePath,
                                                          final String rowDelimiter,
                                                          final String colDelimiter) {
        String contents = getFileContentsAsString(filePath);
        String[] rows = contents.split(rowDelimiter);
        Integer[][] grid = new Integer[rows.length][];
        int rowIndex = 0;
        for (String row : rows) {
            String[] cols = row.split(colDelimiter);
            Integer[] formattedCols = new Integer[cols.length];
            for (int i = 0; i< cols.length; i++) {
                try {
                    formattedCols[i] = Integer.parseInt(cols[i].replaceAll("\\s", ""));
                } catch (NumberFormatException e) {
                    formattedCols[i] = null;
                }
            }
            grid[rowIndex] = formattedCols;
            rowIndex++;
        }
        return grid;
    }

    public static void main(String[] args) {
        DebugHelper.printNestedArray(getFileContentsAsGrid("src/Problems/_0011_Largest_Product_In_A_Grid/Grid.txt"));
        DebugHelper.printNestedArray(getFileContentsAsGrid("src/Problems/_0018_Maximum_Path_Sum_I/Triangle.txt"));

    }
}
