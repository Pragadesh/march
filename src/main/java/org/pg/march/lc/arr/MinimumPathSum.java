package org.pg.march.lc.arr;

/*
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

	private final static int[] moves = { 1, 0, 1 };
	
	public int minPathSum(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int[] dp = new int[col];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j == 0) {
					dp[j] += grid[i][j];
				} else {
					dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
				}
			}
		}
		return dp[col - 1];
	}
	
	public int minPathSum2D(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int[][] dp = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = grid[i][j];
					continue;
				}
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = 0; k < moves.length - 1; k++) {
					int dy = i - moves[k];
					int dx = j - moves[k + 1];
					if (dy >= 0 && dy < row && dx >= 0 && dx < col) {
						dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[dy][dx]);
					}
				}
			}
		}
		return dp[row - 1][col - 1];
	}
}
