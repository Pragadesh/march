package org.pg.march.lc.game;

/*
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int C = obstacleGrid[0].length;
		int[] dp = new int[C];
		dp[0] = 1;
		for(int[] rows : obstacleGrid) {
			for(int i = 0; i<rows.length;i++) {
				if(rows[i] == 1) {
					dp[i] = 0;
				}else if(i > 0) {
					dp[i] += dp[i-1];
				}
			}
		}
		return dp[C-1];
	}
}
