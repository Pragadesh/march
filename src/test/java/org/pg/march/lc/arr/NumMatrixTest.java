package org.pg.march.lc.arr;

import org.junit.Test;

import junit.framework.Assert;

public class NumMatrixTest {

	
	@Test
    public void testcase1() {
		int[][] matrix = {
				  {3, 0, 1, 4, 2},
				  {5, 6, 3, 2, 1},
				  {1, 2, 0, 1, 5},
				  {4, 1, 0, 1, 7},
				  {1, 0, 3, 0, 5}
				};
		NumMatrix numMatrix = new NumMatrix(matrix);
		Assert.assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
		Assert.assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2));
		Assert.assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4));
    }
}
