package Problems._0101To0150._0149_Maximum_sum_Subsequence;

import Stats.RunInfo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;

public class MaxSumSubsequence {
    private static int[] values;
    private static int edgeLength;
    private static final int ONE_MILLION = 1000000;

    private static void init() {
        edgeLength = 2000;
        int gridSize = edgeLength * edgeLength;
        values = new int[gridSize];

        for (int i = 1; i <= 55; i++) {
            long s = (100003L - 200003L * i + 300007L * i * i * i) % ONE_MILLION;
            if (s < 0) s += ONE_MILLION;
            values[i - 1] = (int)(s - 500000);
        }

        for (int i = 56; i <= gridSize; i++) {
            int index = i - 1;
            long s = (values[index - 24] + values[index - 55]) % ONE_MILLION;
            if (s < 0) s += ONE_MILLION;
            values[index] = (int)(s - 500000);
        }
    }

    private static void initTest() {
        edgeLength = 4;
        values = new int[] {
                -2, 5, 3, 2,
                9, -6, 5, 1,
                3, 2, 7, 3,
                -1, 8, -4, 8
        };
    }

    private static int checkGrid() {
        int max = values[0];
        max = Math.max(max, horizontalMax());
        max = Math.max(max, verticalMax());
        max = Math.max(max, negativeDiagonalMax());
        max = Math.max(max, positiveDiagonalMax());
        return max;
    }

    private static int checkGridConcurrent() {
        try (ExecutorService executor = Executors.newFixedThreadPool(4)) {
            Future<Integer> h = executor.submit(MaxSumSubsequence::horizontalMax);
            Future<Integer> v = executor.submit(MaxSumSubsequence::verticalMax);
            Future<Integer> d1 = executor.submit(MaxSumSubsequence::negativeDiagonalMax);
            Future<Integer> d2 = executor.submit(MaxSumSubsequence::positiveDiagonalMax);

            int max = values[0];
            max = Math.max(max, h.get());
            max = Math.max(max, v.get());
            max = Math.max(max, d1.get());
            max = Math.max(max, d2.get());
            return max;
        } catch (InterruptedException | ExecutionException e) {
            return Integer.MIN_VALUE;
        }
    }

    private static int horizontalMax() {
        int max = values[0];

        for (int start = 0; start < edgeLength * edgeLength; start += edgeLength) {
            int candidateMax = getMax(start, start + edgeLength, 1);
            if (candidateMax > max) max = candidateMax;
        }

        return max;
    }

    private static int verticalMax() {
        int max = values[0];

        for (int start = 0; start < edgeLength; start++) {
            int candidateMax = getMax(start, edgeLength * edgeLength, edgeLength);
            if (candidateMax > max) max = candidateMax;
        }

        return max;
    }

    private static int negativeDiagonalMax() {
        int max = values[0];
        int stop = edgeLength * edgeLength;

        for (int start = edgeLength * (edgeLength - 1); start > 0; start -= edgeLength) {
            int candidateMax = getMax(start, stop, edgeLength + 1);
            if (candidateMax > max) max = candidateMax;
        }

        for (int start = 0; start < edgeLength; start++) {
            int candidateMax = getMax(start, stop, edgeLength + 1);
            if (candidateMax > max) max = candidateMax;
            stop -= edgeLength;
        }

        return max;
    }

    private static int positiveDiagonalMax() {
        int max = values[0];
        int stop = 0;

        for (int start = 0; start < edgeLength * (edgeLength - 1); start += edgeLength) {
            int candidateMax = getMax(start, -(edgeLength - 1), i -> i > stop);
            if (candidateMax > max) max = candidateMax;
        }

        int count = 0;
        for (int start = edgeLength * (edgeLength - 1); start < edgeLength * edgeLength; start++) {
            int newStop = edgeLength * count;
            int candidateMax = getMax(start, -(edgeLength - 1), i -> i > newStop);
            if (candidateMax > max) max = candidateMax;
            count++;
        }

        return max;
    }

    private static int getMax(int start, int stop, int step) {
        return getMax(start,
                step,
                i -> i < stop);
    }

    private static int getMax(int start, int step, Predicate<Integer> condition) {
        int max = values[start];
        int current = max;
        for (int i = start + step; condition.test(i); i += step) {
            if (current > max) max = current;
            if (current < 0) current = 0;
            current += values[i];
        }
        if (current > max) max = current;
        return max;
    }

    public static void solutionTest() {
        initTest();
        System.out.println(checkGrid());
    }
    public static void solution() {
        init();
        System.out.println(checkGrid());
    }

    public static void solutionConcurrent() {
        init();
        System.out.println(checkGridConcurrent());
    }

    public static void main(String[] args) {
        RunInfo.showRuntimeMs(MaxSumSubsequence::solution);
    }
}
