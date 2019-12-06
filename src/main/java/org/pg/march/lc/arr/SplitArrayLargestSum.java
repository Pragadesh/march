package org.pg.march.lc.arr;

/*
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class SplitArrayLargestSum {

	public int splitArray(int[] nums, int m) {

		int[] sum = new int[nums.length + 1];
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}

		int[][] dp = new int[nums.length + 1][m + 1]; // minimum largest subarray sum for splitting nums[0..i] into j
														// parts.

		for (int i = 0; i <= nums.length; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[0][0] = 0;

		for (int parts = 1; parts <= m; parts++) {

			for (int right = 1; right <= nums.length; right++) {
				for (int k = 0; k < right; k++) {
					dp[right][parts] = Math.min(dp[right][parts], Math.max(dp[k][parts - 1], sum[right] - sum[k]));
				}
			}
		}

		return dp[nums.length][m];
	}
}
