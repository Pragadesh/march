package org.pg.march.lc.game;

/*
 * https://leetcode.com/problems/unique-paths-iii/
 */
public class UniquePathsIII {

	private int R;
	private int C;

	private int tx, ty;

	Integer[][][] memo;

	private int[] moves = { -1, 0, 1, 0, -1 };

	public int uniquePathsIII(int[][] grid) {

		R = grid.length;
		C = grid[0].length;
		int sx = 0;
		int sy = 0;
		int target = 0;

		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (grid[row][col] % 2 == 0) {
					target |= 1 << pos(row, col);
				} 
				if (grid[row][col] == 1) {
					sx = row;
					sy = col;
				} else if (grid[row][col] == 2) {
					tx = row;
					ty = col;
				}
			}
		}
		memo = new Integer[R][C][1 << R * C];
		return dp(sx, sy, target);
	}

	private int dp(int x, int y, int todo) {
		if (memo[x][y][todo] != null) {
			return memo[x][y][todo];
		}
		if (x == tx && y == ty) {
			return (todo == 0 ? 1 : 0);
		}
		int ans = 0;
		for (int move = 0; move < moves.length - 1; move++) {
			int dx = x + moves[move];
			int dy = y + moves[move + 1];
			if (dx >= 0 && dy >= 0 && dx < R && dy < C && (todo & (1 << pos(dx, dy))) > 0) {
				ans += dp(dx, dy, todo ^ (1 << pos(dx, dy)));
			}
		}
		memo[x][y][todo] = ans;
		return ans;
	}

	private int pos(int row, int col) {
		return (row * C) + col;
	}
}
