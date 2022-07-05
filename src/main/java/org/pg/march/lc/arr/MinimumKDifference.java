package org.pg.march.lc.arr;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class MinimumKDifference {

    public int minimumDifference(int[] nums, int k) {
        if (nums == null || nums.length < k) return 0;
        if (k == 1) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = k-1; i< nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i+1-k]);
        }
        return min;
    }
}
