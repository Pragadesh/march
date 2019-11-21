package org.pg.march.lc.game;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class UniquePathsIIITest {

	private UniquePathsIII uniquePathsIII;

	@Before
	public void setup() {
		uniquePathsIII = new UniquePathsIII();
	}

	@Test
	public void testcase1() {
		int[][] grid = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		Assert.assertEquals(2, uniquePathsIII.uniquePathsIII(grid));
	}

	@Test
	public void testcase2() {
		int[][] grid = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
		Assert.assertEquals(4, uniquePathsIII.uniquePathsIII(grid));
	}

	@Test
	public void testcase3() {
		int[][] grid = new int[][] { { 0, 1 }, { 2, 0 } };
		Assert.assertEquals(0, uniquePathsIII.uniquePathsIII(grid));
	}
}
