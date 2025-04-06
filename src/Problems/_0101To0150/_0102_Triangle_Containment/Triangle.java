package Problems._0101To0150._0102_Triangle_Containment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Triangle {
    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coordinate(x=" + x + ", y=" + y + ")";
        }
    }

    private Coordinate[] coordinates;

    public Triangle(Collection<Integer> coords) {
        if (coords.size() != 6) {
            throw new IllegalArgumentException("A triangle requires exactly 6 coordinates.");
        }

        List<Integer> coordList = new ArrayList<>(coords);
        this.coordinates = new Coordinate[3];

        for (int i = 0; i < 3; i++) {
            int x = coordList.get(i * 2);
            int y = coordList.get(i * 2 + 1);
            this.coordinates[i] = new Coordinate(x, y);
        }
    }

    public boolean containsOrigin() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Triangle Coordinates: \n");
        for (int i = 0; i < coordinates.length; i++) {
            sb.append("Point ").append(i + 1).append(": ")
                    .append(coordinates[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
