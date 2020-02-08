package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class Search2DMatrix2Test {

	private Search2DMatrix2 search2DMatrix2;

	@Before
	public void setup() {
		search2DMatrix2 = new Search2DMatrix2();
	}

	@Test
	public void testcase1() {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
//		Assert.assertEquals(true, search2DMatrix2.searchMatrix(matrix, 5));
		Assert.assertEquals(true, search2DMatrix2.searchMatrix(matrix, 12));
	}
}
