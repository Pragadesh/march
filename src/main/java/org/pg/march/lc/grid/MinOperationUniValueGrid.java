package org.pg.march.lc.grid;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
 */
public class MinOperationUniValueGrid {

    public int minOperations(int[][] grid, int x) {
        int colSize = grid[0].length;
        int[] nums = new int[grid.length * colSize];
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < colSize; j++) {
                nums[i*colSize + j] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        for (int i = 1; i < dp.length; i++) {
            if ((nums[i] - nums[i-1]) % x != 0) return -1;
            dp[i] = dp[i-1] + (nums[i] - nums[i-1]) / x * i;
        }
        int min = dp[dp.length - 1];
        int ops = 0;
        for (int i = dp.length - 1; i > 0; i--) {
            ops += (nums[i] - nums[i-1]) / x * (dp.length - i);
            min = Math.min(min, ops + dp[i-1]);
        }
        return min;
    }

    public int minOperationsMedian(int[][] grid, int x) {
        int colSize = grid[0].length;
        int[] nums = new int[grid.length * colSize];
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < colSize; j++) {
                nums[i*colSize + j] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        int median = nums[(nums.length-1)/2];
        int count = 0;
        for (int num : nums) {
            int diff = Math.abs(median - num);
            if (diff % x != 0) return -1;
            count += (diff / x);
        }
        return count;
    }

}
