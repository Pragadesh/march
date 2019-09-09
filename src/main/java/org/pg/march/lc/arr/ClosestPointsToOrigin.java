package org.pg.march.lc.arr;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 */
public class ClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {

        if (points == null || points.length == 0 || K == 0) {
            return new int[][] { {} };
        }
        sort(points, 0, points.length - 1, K);
        int[][] result = new int[K][];
        for(int i=0; i<K; i++) {
            result[i] = points[i];
        }
        return result;
    }

    private void sort(int[][] points, int low, int high, int K) {
        if (high <= low) {
            return;
        }
        int partition = partition(points, low, high);
        if (partition == K) {
            return;
        } else if (partition < K) {
            sort(points, partition + 1, high, K);
        } else {
            sort(points, low, partition - 1, K);
        }

    }

    private int partition(int[][] points, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(points[++i], points[low])) {
                if (i == high)
                    break;
            }
            while (less(points[low], points[--j])) {
                if (j == low)
                    break;
            }
            if (i >= j) {
                break;
            }
            exchange(points, i, j);
        }
        exchange(points, low, j);
        return j;
    }

    private boolean less(int[] point1, int[] point2) {
        return compareTo(point1, point2) < 0;
    }

    private void exchange(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int compareTo(int[] point1, int[] point2) {
        double distanceSqr1 = Math.pow(point1[0], 2) + Math.pow(point1[1], 2);
        double distanceSqr2 = Math.pow(point2[0], 2) + Math.pow(point2[1], 2);
        return Double.compare(distanceSqr1, distanceSqr2);
    }
}
