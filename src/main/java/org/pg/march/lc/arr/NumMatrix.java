package org.pg.march.lc.arr;

/*
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrix {

	private final int[][] matrix;
	private final int R;
	private int C;
	
	/**
	 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
	 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
	 */
	public NumMatrix(int[][] matrix) {
		this.matrix = matrix;
		this.R = matrix.length;
		this.C = 0;
		if(R > 0) {
			this.C = matrix[0].length;
			for (int i = 0; i < R; i++) {
				for (int j = 1; j < C; j++) {
					matrix[i][j] += matrix[i][j - 1];
				}
			}
			for (int i = 0; i < C; i++) {
				for (int j = 1; j < R; j++) {
					matrix[j][i] += matrix[j - 1][i];
				}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if(row1 < 0 || row2 < row1 || row2 >= R) {
			throw new IllegalArgumentException();
		}
		if(col1 < 0 || col2 < col1 || col2 >= C) {
			throw new IllegalArgumentException();
		}
		int area = matrix[row2][col2];
		if(row1 > 0 && col1 > 0) {
			area += matrix[row1 - 1][col1 - 1];
			area -= matrix[row1 - 1][col2];
			area -= matrix[row2][col1 - 1];
		}else if (row1 > 0) {
			area -= matrix[row1 - 1][col2];
		}else if (col1 > 0) {
			area -= matrix[row2][col1 - 1];
		}
		return area;
	}
}
