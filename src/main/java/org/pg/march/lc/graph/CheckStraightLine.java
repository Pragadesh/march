package org.pg.march.lc.graph;

public class CheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2) {
            return false;
        }
        int pX = coordinates[0][0], pY = coordinates[0][1];
        int qX = coordinates[1][0], qY = coordinates[1][1];
        for (int[] c : coordinates) {
            if ((c[1] - pY) * (c[0] - qX) != (c[1] - qY) * (c[0] - pX)) {
                return false;
            }
        }
        return true;
    }
}
