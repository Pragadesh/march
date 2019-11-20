package org.pg.march.lc.matrix;

/*
 * https://leetcode.com/contest/weekly-contest-162/problems/number-of-closed-islands/
 */
public class ClosedIslands {

	private int R;
	private int C;
	private boolean[] visited;
	private int[][] grid;
	private static int[] moves = { -1, 0, 1, 0, -1 };

	public int closedIsland(int[][] grid) {

		if (grid == null || grid.length <= 1) {
			return 0;
		}
		this.grid = grid;
		R = grid.length;
		C = grid[0].length;
		int N = R * C;
		visited = new boolean[N];

		int noOfIslands = 0;
		for (int r = 1; r < R - 1; r++) {
			for (int c = 1; c < grid[r].length - 1; c++) {
				if (grid[r][c] == 0 && !visited[to1D(r, c)]) {
					if (!dfs(r, c)) {
						System.out.println(String.format("[%d, %c]", r+1, (char)c + 65));
						noOfIslands++;
					}
				}
			}
		}
		return noOfIslands;
	}

	private boolean dfs(int r, int c) {
		visited[to1D(r, c)] = true;
		boolean outerEdge = isOuterEdge(r, c);
		for (int move = 0; move < moves.length - 1; move++) {
			int dr = r + moves[move];
			int dc = c + moves[move + 1];
			if (isValid(dr, dc) && grid[dr][dc] == 0 && !visited[to1D(dr, dc)]) {
				outerEdge = outerEdge | dfs(dr, dc);
			}
		}
		return outerEdge;
	}

	private int to1D(int r, int c) {
		return (r * C) + c;
	}

	private boolean isValid(int r, int c) {
		return (r >= 0 && c >= 0 && r < R && c < C);
	}

	private boolean isOuterEdge(int r, int c) {
		return (r <= 0 || c <= 0 || r >= R - 1 || c >= C - 1);
	}
}
