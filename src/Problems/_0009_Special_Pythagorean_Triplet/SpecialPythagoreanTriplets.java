package Problems._0009_Special_Pythagorean_Triplet;

import Stats.Counter;
import Stats.RunInfo;

public class SpecialPythagoreanTriplets {
    private static final int maximum = 1000;
    public static void solutionNewtonsMethod() {
        for (int m = 1; Counter.countCondition(m < maximum); m++) {
            Counter.incrementLoopCount();
            for (int n = 1; Counter.countCondition(n < m); n++) {
                Counter.incrementLoopCount();
                if (Counter.countCondition(n % 2 == 0 || m % 2 == 0)) {
                    int a = (m * m) - (n * n);
                    int b = 2 * m * n;
                    int c = (m * m) + (n * n);

                    if (Counter.countCondition((a + b + c) == maximum)) {
                        System.out.println(a * b * c);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(SpecialPythagoreanTriplets::solutionNewtonsMethod);
    }
}
