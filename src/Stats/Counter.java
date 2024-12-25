package Stats;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Counter {
    private static long totalLoopsEntered = 0;
    private static long totalConditionalsChecked = 0;
    public static void reset() {
        totalLoopsEntered = 0;
        totalConditionalsChecked = 0;
    }

    public static void printInfo() {
        System.out.println(totalLoopsEntered + " loops entered and\n"
                + totalConditionalsChecked + " conditionals checked");
    }

    public static <T> void forLoop(T start, Predicate<T> condition, Function<T, T> modifier, Consumer<T> action) {
        for (T current = start; checkCondition(current, condition); current = modifier.apply(current)) {
            incrementLoopCount();
            action.accept(current);
        }
    }
    public static <T> void forLoop(T start, Predicate<T> condition, Function<T, T> modifier, Runnable action) {
        for (T current = start; checkCondition(current, condition); current = modifier.apply(current)) {
            incrementLoopCount();
            action.run();
        }
    }

    public static <T> boolean checkCondition(T check, Predicate<T> condition) {
        incrementConditionalCount();
        return condition.test(check);
    }

    public static boolean countCondition(boolean input) {
        incrementConditionalCount();
        return input;
    }

    public static void incrementLoopCount() {
        totalLoopsEntered++;
    }

    public static void incrementConditionalCount() {
        totalConditionalsChecked++;
    }
}
