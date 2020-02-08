package org.pg.march.lc.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/campus-bikes/
 */
public class CampusBikes {

    public int[] assignBikes(int[][] workers, int[][] bikes) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {

            int compare = Integer.compare(a[0], b[0]);
            if (compare == 0) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
            return compare;
        });

        for (int b = 0; b < bikes.length; b++) {
            for (int w = 0; w < workers.length; w++) {
                int distance = Math.abs(workers[w][0] - bikes[b][0]) + Math.abs(workers[w][1] - bikes[b][1]);
                pq.offer(new int[] { distance, w, b });
            }
        }

        int[] res = new int[workers.length];
        boolean[] bikesTaken = new boolean[bikes.length];
        Arrays.fill(res, -1);
        int noOfAssignedWOrkers = 0;
        while (!pq.isEmpty() && noOfAssignedWOrkers <= workers.length) {
            int[] node = pq.poll();
            int w = node[1];
            int b = node[2];
            if(res[w] >= 0 || bikesTaken[b]) {
                continue;
            }
            res[w] = b;
            bikesTaken[b] = true;
            noOfAssignedWOrkers++;
        }

        return res;
    }
}
