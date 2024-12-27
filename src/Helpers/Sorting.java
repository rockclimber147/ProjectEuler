package Helpers;

import Stats.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Sorting {
    public static <T> void mergeSort(List<T> list, BiFunction<T, T, Integer> comparator) {
        if (Counter.countCondition(list.size() <= 1)) {
            return;
        }

        int mid = list.size() / 2;
        List<T> left = new ArrayList<>(list.subList(0, mid));
        List<T> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(list, left, right, comparator);
    }

    private static <T> void merge(List<T> list, List<T> left, List<T> right, BiFunction<T, T, Integer> comparator) {
        int i = 0, j = 0, k = 0;

        while (Counter.countCondition(i < left.size() && j < right.size())) {
            Counter.incrementLoopCount();

            if (Counter.countCondition(comparator.apply(left.get(i), right.get(j)) <= 0)) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (Counter.countCondition(i < left.size())) {
            Counter.incrementLoopCount();
            list.set(k++, left.get(i++));
        }

        while (Counter.countCondition(j < right.size())) {
            Counter.incrementLoopCount();
            list.set(k++, right.get(j++));
        }
    }
}
