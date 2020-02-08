package org.pg.march.lc.dp;

/*
 * https://leetcode.com/problems/burst-balloons/
 */
public class BurstBalloons {

	
	public int maxCoinsTopDown(int[] nums) {
		int[] coins = new int[nums.length + 2];
		int N = 1;
		for (int num : nums) {
			if (num > 0) {
				coins[N++] = num;
			}
		}
		coins[0] = 1;
		coins[N++] = 1;
		int[][] dp = new int[N][N];
		return td(coins, dp, 0, N - 1);
	}
	
	private int td(int[] coins, int[][] dp, int left, int right) {
		if(dp[left][right] > 0) {
			return dp[left][right];
		}
		int max = 0;
		for(int i = left + 1; i < right; i++) {
			max = Math.max(max, coins[left] * coins[i] * coins[right] + td(coins, dp, left, i) + td(coins, dp, i, right));
		}
		dp[left][right] = max;
		return max;
	}
	
	public int maxCoins2(int[] nums) {
		int[] coins = new int[nums.length + 2];
		int N = 1;
		for (int num : nums) {
			if (num > 0) {
				coins[N++] = num;
			}
		}
		coins[0] = 1;
		coins[N++] = 1;
		int[][] dp = new int[N][N];
		for (int k = 2; k < N; k++) {
			for (int left = 0; left < N - k; left++) {
				int right = left + k;
				for (int i = left + 1; i < right; i++) {
					dp[left][right] = Math.max(dp[left][right], coins[left] * coins[i] * coins[right] + dp[left][i] + dp[i][right]);
				}
			}
		}
		return dp[0][N-1];
	}

	public int maxCoins(int[] nums) {
		int[] numsBoundary = new int[nums.length + 2];
		int N = 1;
		for (int num : nums) {
			numsBoundary[N++] = num;
		}
		numsBoundary[0] = numsBoundary[N] = 1;
		return burstWithDP(numsBoundary);
	}

	private int burstWithDP(int[] numsBoundary) {
		int N = numsBoundary.length;
		int[][] dp = new int[N][N];

		for (int size = 2; size < N; size++) {
			for (int left = 0; left < N - size; left++) {
				int right = left + size;
				for (int i = left + 1; i < right; i++) {
					dp[left][right] = Math.max(dp[left][right],
							dp[left][i] + numsBoundary[left] * numsBoundary[i] * numsBoundary[right] + dp[i][right]);
				}
			}
		}
		return dp[0][N - 1];
	}

	private int burstWithMemoization(int[] numsBoundary) {
		int N = numsBoundary.length;
		Integer[][] memo = new Integer[N][N];
		return burstWithMemoization(numsBoundary, memo, 0, N - 1);
	}

	private int burstWithMemoization(int[] numsBoundary, Integer[][] memo, int left, int right) {
		if (memo[left][right] != null) {
			return memo[left][right];
		}
		int ans = 0;
		for (int i = left + 1; i < right; i++) {
			ans = Math.max(ans,
					numsBoundary[left] * numsBoundary[i] * numsBoundary[right]
							+ burstWithMemoization(numsBoundary, memo, left, i)
							+ burstWithMemoization(numsBoundary, memo, i, right));
		}
		memo[left][right] = ans;
		return ans;
	}
}
