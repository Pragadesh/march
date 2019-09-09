package org.pg.march.lc.arr;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return lengthOfLISDynamicWithBinarySearch(nums);
    }

    private int lengthOfLISByMemoization(int[] nums) {
        int[] len = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && len[i] <= len[j]) {
                    len[i] = len[j] + 1;
                }
            }
            max = Math.max(max, len[i]);
        }
        return max;
    }
    
    public int lengthOfLISDynamicWithBinarySearch(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
