package org.pg.march.lc.board;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {

	private List<List<String>> result;
	private int N;

	public List<List<String>> solveNQueens(int n) {
		result = new ArrayList<>();
		this.N = n;
		boolean[][] board = new boolean[n][n];
		boolean[] columns = new boolean[n];
		boolean[] uphill = new boolean[2 * n]; // id is row + col
		boolean[] downhill = new boolean[2 * n]; // id is row - col + n
		traverse(0, columns, uphill, downhill, board);
		return result;
	}

	private void traverse(int row, boolean[] columns, boolean[] uphill, boolean[] downhill, boolean[][] board) {
		if (row >= N) {
			List<String> done = new ArrayList<>();
			for(boolean[] rowStatus : board) {
				StringBuilder builder = new StringBuilder();
				for(boolean cellStatus : rowStatus) {
					if(cellStatus)
						builder.append("Q");
					else
						builder.append(".");
				}
				done.add(builder.toString());
			}
			result.add(done);
			return;
		}
		for (int col = 0; col < N; col++) {
			if(isAllowed(row, col, columns, uphill, downhill)) {
				placeQueen(row, col, columns, uphill, downhill);
				board[row][col] = true;
				traverse(row + 1, columns, uphill, downhill, board);
				removeQueen(row, col, columns, uphill, downhill);
				board[row][col] = false;
			}
		}
	}

	private boolean isAllowed(int row, int col, boolean[] columns, boolean[] uphill, boolean[] downhill) {
		int uphillIndex = row + col;
		int downhillIndex = row - col + N;
		return !columns[col] && !uphill[uphillIndex] && !downhill[downhillIndex];
	}

	private void placeQueen(int row, int col, boolean[] columns, boolean[] uphill, boolean[] downhill) {
		columns[col] = true;
		uphill[row + col] = true;
		downhill[row - col + N] = true;
	}

	private void removeQueen(int row, int col, boolean[] columns, boolean[] uphill, boolean[] downhill) {
		columns[col] = false;
		uphill[row + col] = false;
		downhill[row - col + N] = false;
	}
}
