package Problems._0101To0150._0102_Triangle_Containment;

import Helpers.FileHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TriangleContainment {
    public static void solution() {
        Iterator<String> lines = FileHelper
                .readFileLineByLine("src/Problems/_0101To0150/_0102_Triangle_Containment/triangles.txt");
        if (lines == null) {
            System.out.println(" Error reading file");
            return;
        }
        int totalContainingOrigin = 0;
        while (lines.hasNext()) {
            ArrayList<Integer> vals = new ArrayList<>(Arrays.stream(lines.next().split(","))
                    .map(Integer::parseInt)
                    .toList());
            if (new Triangle(vals).containsOrigin()) totalContainingOrigin++;
        }
        System.out.println(totalContainingOrigin);
    }

    public static void main(String[] args) {
        solution();
    }
}
