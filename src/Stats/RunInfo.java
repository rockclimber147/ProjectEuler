package Stats;

public class RunInfo {
    public static void executeWithInfo(Runnable action) {

        reset();
        long elapsedTimeMs = getRuntimeMs(action);
        System.out.println("Finished in " + elapsedTimeMs + " ms with");
        Counter.printInfo();
        System.out.println();
    }

    public static long getRuntimeMs(Runnable action) {
        long startTime = System.currentTimeMillis();
        action.run();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void reset() {
        Counter.reset();
    }
}
