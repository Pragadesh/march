package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MinimumPathSumTest {

	private MinimumPathSum minimumPathSum;

    @Before
    public void setup() {
        minimumPathSum = new MinimumPathSum();
    }

    @Test
    public void testcase1() {
        int[][] grid = new int[][] {
        	  {1,3,1},
        	  {1,5,1},
        	  {4,2,1}};
        Assert.assertEquals(7, minimumPathSum.minPathSum(grid));
    }
}
