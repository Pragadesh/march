package org.pg.march.lc.arr;

/*
 * https://leetcode.com/problems/couples-holding-hands/
 */
public class CouplesHoldingHand {

    public int minSwapsCouples(int[] row) {
        int[] posArr = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            posArr[row[i]] = i;
        }
        int swaps = 0;
        for (int i = 0; i < row.length; i = i + 2) {

        }
        return swaps;
    }
}
