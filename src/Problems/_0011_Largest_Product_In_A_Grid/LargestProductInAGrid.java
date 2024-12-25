package Problems._0011_Largest_Product_In_A_Grid;

import Helpers.FileHelper;
import Stats.Counter;
import Stats.RunInfo;

public class LargestProductInAGrid {
    private static final String filePath = "src/Problems/_0011_Largest_Product_In_A_Grid/Grid.txt";
    private static final String rowDelimiter = "\n";
    private static final String colDelimiter = " ";

    private static int[][] grid;
    private static int searchWidth = 4;
    private static long maxProduct = 0;

    private static void init() {
        grid = FileHelper.getFileContentsAsGrid(filePath, rowDelimiter, colDelimiter);
    }

    public static void solution() {
        SearchParams params = new SearchParams(searchWidth, grid);

        params.configure(SearchMethod.HORIZONTAL);
        checkGridProduct(params);

        params.configure(SearchMethod.VERTICAL);
        checkGridProduct(params);

        params.configure(SearchMethod.DIAGONAL_DOWN_RIGHT);
        checkGridProduct(params);

        params.configure(SearchMethod.DIAGONAL_DOWN_LEFT);
        checkGridProduct(params);

        System.out.println("max product: " + maxProduct);
    }

    private static void checkGridProduct(SearchParams params) {
        for (int row = params.getRowStart();
             Counter.countCondition(row < params.getRowEnd());
             row = params.getRowModifier().apply(row)){
            Counter.incrementLoopCount();

            for (int col = params.getColStart();
                 Counter.countCondition(col < params.getColEnd());
                 col = params.getColModifier().apply(col)) {
                Counter.incrementLoopCount();

                long currentProduct = 1;
                for (int i = 0; Counter.countCondition(i < searchWidth); i++) {
                    int rowToSearch = row + params.getRowSearchMethod().apply(i);
                    int colToSearch = col + params.getColSearchMethod().apply(i);
                    int gridValue = grid[rowToSearch][colToSearch];

                    currentProduct *= gridValue;
                }
                System.out.println(currentProduct);
                if (Counter.countCondition(currentProduct > maxProduct)) {
                    maxProduct = currentProduct;
                }
            }
        }
    }

    public static void main(String[] args) {
        init();
        RunInfo.executeWithInfo(LargestProductInAGrid::solution);
    }
}
