package Problems._0101To0150._0102_Triangle_Containment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Triangle {
    private static final double EPSILON = 1E-4;
    int[] p1;
    int[] p2;
    int[] p3;
    public Triangle(Collection<Integer> coords) {
        if (coords.size() != 6) {
            throw new IllegalArgumentException("A triangle requires exactly 6 coordinates.");
        }
        List<Integer> coordList = new ArrayList<>(coords);
        this.p1 = new int[] {coordList.get(0), coordList.get(1)};
        this.p2 = new int[] {coordList.get(2), coordList.get(3)};
        this.p3 = new int[] {coordList.get(4), coordList.get(5)};
    }

    public Triangle(int[] p1, int[] p2, int[] p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public boolean contains(int[] point) {
        double thisArea = this.area();
        double smallerAreas = new Triangle(this.p1, this.p2, point).area()
                + new Triangle(this.p1, point, this.p3).area()
                + new Triangle(point, this.p2, this.p3).area();
        return Math.abs(thisArea - smallerAreas) < EPSILON;
    }

    public double area() {
        return 0.5 * Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]));
    }
}
