package Problems._0001To00025._0011_Largest_Product_In_A_Grid;

import java.util.function.Function;

public class SearchParams {
    private static final Function<Integer, Integer> INCREMENT_BY_ONE = number -> number + 1;
    private static final Function<Integer, Integer> KEEP_VALUE = number -> number;
    private static final Function<Integer, Integer> NEGATE = number -> - number;
    private static final Function<Integer, Integer> SET_TO_ZERO = number -> 0;

    private final int searchLength;
    private final int gridColCount;
    private final int gridRowCount;
    private int rowStart;
    private int rowEnd;
    private Function<Integer, Integer> rowModifier;
    private Function<Integer, Integer> rowSearchMethod;
    private int colStart;
    private int colEnd;
    private Function<Integer, Integer> colModifier;
    private Function<Integer, Integer> colSearchMethod;

    public SearchParams(final int searchLength, int[][] grid){
        this.searchLength = searchLength - 1;
        this.gridRowCount = grid.length;
        this.gridColCount = grid[0].length;
    }

    public void configure(final SearchMethod method) {
        switch (method) {
            case HORIZONTAL -> this.configureHorizontal();
            case VERTICAL -> this.configureVertical();
            case DIAGONAL_DOWN_RIGHT -> this.configureDiagonalRight();
            case DIAGONAL_DOWN_LEFT -> this.configureDiagonalLeft();
        }
        debugPrint(method);
    }

    private void configureHorizontal() {
        this.rowStart = 0;
        this.rowEnd = gridRowCount;
        this.rowModifier = INCREMENT_BY_ONE;
        this.rowSearchMethod = SET_TO_ZERO;

        this.colStart = 0;
        this.colEnd = gridColCount - searchLength;
        this.colModifier = INCREMENT_BY_ONE;
        this.colSearchMethod = KEEP_VALUE;
    }

    private void configureVertical() {
        this.rowStart = 0;
        this.rowEnd = gridRowCount - searchLength;
        this.rowModifier = INCREMENT_BY_ONE;
        this.rowSearchMethod = KEEP_VALUE;

        this.colStart = 0;
        this.colEnd = gridColCount;
        this.colModifier = INCREMENT_BY_ONE;
        this.colSearchMethod = SET_TO_ZERO;
    }

    private void configureDiagonalRight() {
        this.rowStart = 0;
        this.rowEnd = gridRowCount - searchLength;
        this.rowModifier = INCREMENT_BY_ONE;
        this.rowSearchMethod = KEEP_VALUE;

        this.colStart = 0;
        this.colEnd = gridColCount - searchLength;
        this.colModifier = INCREMENT_BY_ONE;
        this.colSearchMethod = KEEP_VALUE;
    }

    private void configureDiagonalLeft() {
        this.rowStart = 0;
        this.rowEnd = gridRowCount - searchLength;
        this.rowModifier = INCREMENT_BY_ONE;
        this.rowSearchMethod = KEEP_VALUE;

        this.colStart = searchLength;
        this.colEnd = gridColCount;
        this.colModifier = INCREMENT_BY_ONE;
        this.colSearchMethod = NEGATE;
    }

    private void debugPrint(SearchMethod method) {
        System.out.println(method);
        System.out.println("rowStart: " + rowStart + " rowEnd: " + rowEnd);
        System.out.println("colStart: " + colStart + " colEnd: " + colEnd);
    }

    public int getRowStart() {
        return rowStart;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public Function<Integer, Integer> getRowModifier() {
        return rowModifier;
    }

    public Function<Integer, Integer> getRowSearchMethod() {
        return rowSearchMethod;
    }

    public int getColStart() {
        return colStart;
    }

    public int getColEnd() {
        return colEnd;
    }

    public Function<Integer, Integer> getColModifier() {
        return colModifier;
    }

    public Function<Integer, Integer> getColSearchMethod() {
        return colSearchMethod;
    }
}
