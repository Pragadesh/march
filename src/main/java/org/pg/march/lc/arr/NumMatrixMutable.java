package org.pg.march.lc.arr;

/*
 * https://leetcode.com/problems/range-sum-query-2d-mutable/
 */



/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
public class NumMatrixMutable {

	private final int[][] matrix;
	private final int R;
	private int C;
	
public NumMatrixMutable(int[][] matrix) {
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
    
    public void update(int row, int col, int val) {
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return -1;
    }
}
