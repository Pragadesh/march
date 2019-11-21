package org.pg.march.lc.graph;

/*
 * https://leetcode.com/problems/cherry-pickup/
 */
public class CherryPickup {

	private final static int[] moves = { 1, 0, 1 };

	public int cherryPickup(int[][] grid) {
		if (grid == null || grid[0][0] == -1) {
			return 0;
		}
		int N = grid.length;
		int[][] dp = _firstTraverseDP(grid);
		System.out.println(dp);
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int cherriesPickedAtCell = dp[row][col];
				if(cherriesPickedAtCell < 0) {
					dp[row][col] = -1;
					continue;
				}
				int possibleCherries = 0;
				for (int m = 0; m < moves.length - 1; m++) {
					int dx = col - moves[m];
					int dy = row - moves[m + 1];
					if (dx >= 0 && dy >= 0 && dp[dy][dx] >= 0) {
						possibleCherries += dp[dy][dx];
					}
				}
				if(possibleCherries > dp[row][col]) {
					dp[row][col] = possibleCherries;
				}
			}
		}
		System.out.println(dp);
		return dp[N-1][N-1];
	}
	
	private int[][] _firstTraverseDP(int[][] grid){
		int N = grid.length;
		int[][] dp = new int[N][N];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int cherriesInCell = grid[row][col];
				dp[row][col] = 0;
				if(cherriesInCell < 0) {
					dp[row][col] = -1;
					continue;
				}
				for (int m = 0; m < moves.length - 1; m++) {
					int dx = col - moves[m];
					int dy = row - moves[m + 1];
					if (dx >= 0 && dy >= 0 && dp[dy][dx] >= 0) {
						dp[row][col] = Math.max(dp[row][col], dp[dy][dx] + cherriesInCell);
					}
				}
			}
		}
		return dp;
	}
	
	public int cherryPickupDFS(int[][] grid) {
		if (grid == null || grid[0][0] == -1) {
			return 0;
		}
		if(grid.length == 1) {
			return grid[0][0] > 0 ? 1 : 0;
		}
		int pivot = 5;
		grid[0][0] += pivot;
		int cherries = _trackMoves(grid, 0, 0, false, grid.length);
		return cherries == 0 ? 0 : cherries - pivot;
	}

	private int _trackMoves(int[][] grid, int x, int y, boolean reverse, int N) {
		System.out.println(String.format("Tracking %d,%d in %s direction", x, y, (reverse ? "Reverse" : "Forward")));
		if (reverse && x == 0 & y == 0) {
			return grid[0][0];
		}
		int max = 0;
		for (int i = 0; i < moves.length - 1; i++) {
			int dx = reverse ? x - moves[i] : x + moves[i];
			int dy = reverse ? y - moves[i + 1] : y + moves[i + 1];
			if (isAllowed(grid, dx, dy, N)) {
				System.out.println(String.format("valid point %d, %d", dx, dy));
				if (reverse && dx == 0 && dy == 0) {
					max = Math.max(max, grid[dx][dy]);
					continue;
				}
				int temp = grid[dx][dy];
				grid[dx][dy] = 0;
				reverse = reverse | (dx == N - 1 && dy == N - 1);
				int cherries = _trackMoves(grid, dx, dy, reverse, N);
				if (cherries > 0) {
					max = Math.max(max, temp + cherries);
				}
				grid[dx][dy] = temp;
			}
		}
		return max;
	}

	private boolean isAllowed(int[][] grid, int x, int y, int N) {
		return (x >= 0 && y >= 0 && x < N && y < N && grid[x][y] >= 0);
	}

}
