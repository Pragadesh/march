package org.pg.march.lc.minimax;

/*
 * https://leetcode.com/problems/stone-game/
 */
public class StoneGame {
	public boolean stoneGame(int[] piles) {
		int N = piles.length;
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i][i] = piles[i - 1];
		}
		for (int len = 2; len <= N; len++) {
			for (int left = 1; left <= N - len + 1; left++) {
				int right = left + len - 1;
				int res = Math.max(dp[left][left] - dp[left + 1][right], dp[right][right] - dp[left][right - 1]);
				dp[left][right] = res;
			}
		}

		return dp[1][N] > 0;
	}
}
