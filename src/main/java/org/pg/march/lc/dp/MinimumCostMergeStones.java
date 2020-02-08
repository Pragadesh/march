package org.pg.march.lc.dp;

public class MinimumCostMergeStones {

	/*
	 * https://leetcode.com/problems/minimum-cost-to-merge-stones/ 1 <=
	 * stones.length <= 30 2 <= K <= 30 1 <= stones[i] <= 100
	 */
	public int mergeStones(int[] stones, int K) {

		int N = stones.length;
		if ((N - 1) % (K - 1) > 0)
			return -1;
		int[] sum = new int[N + 1];
		int[][] dp = new int[N][N];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + stones[i - 1];
		}
		sum[N] = sum[N - 1] + stones[N - 1];
		for (int size = K; size <= N; size++) {

			for (int left = 0; (left + size) <= N; left++) {
				int right = left + size - 1;
				int min = Integer.MAX_VALUE;
				for (int mid = left; mid < right; mid += (K - 1)) {
					min = Math.min(min, dp[left][mid] + dp[mid + 1][right]);
				}
				dp[left][right] = min;
				if((right - left ) % (K -1) == 0) {
					dp[left][right] = min + sum[right + 1] - sum[left];
				}
			}
		}

		return dp[0][N - 1];
	}

}
