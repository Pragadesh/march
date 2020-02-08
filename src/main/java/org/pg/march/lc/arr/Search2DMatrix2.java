package org.pg.march.lc.arr;

/*
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DMatrix2 {

	public boolean searchMatrix(int[][] matrix, int target) {
		return searchMatrixSoln2(matrix, target);
	}
	

	public boolean searchMatrixSoln2(int[][] matrix, int target) {
		
		int row_num = matrix.length;
		int col_num = matrix[0].length;
		
		int begin = 0, end = row_num * col_num - 1;
		
		while(begin <= end){
			int mid = (begin + end) / 2;
			int mid_value = matrix[mid/col_num][mid%col_num];
			
			if( mid_value == target){
				return true;
			
			}else if(mid_value < target){
				//Should move a bit further, otherwise dead loop.
				begin = mid+1;
			}else{
				end = mid-1;
			}
		}
		
		return false;
	}
}
