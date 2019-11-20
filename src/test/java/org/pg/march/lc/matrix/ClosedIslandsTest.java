package org.pg.march.lc.matrix;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ClosedIslandsTest {

	private ClosedIslands closedIslands;

	@Before
	public void setup() {
		closedIslands = new ClosedIslands();
	}

	@Test
	public void testcase1() {
		int[][] grid = { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
		Assert.assertEquals(2, closedIslands.closedIsland(grid));
	}

	@Test
	public void testcase2() {
		int[][] grid = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
		Assert.assertEquals(1, closedIslands.closedIsland(grid));
	}

	@Test
	public void testcase3() {
		int[][] grid = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
		Assert.assertEquals(2, closedIslands.closedIsland(grid));
	}

	@Test
	public void testcase4() {
		int[][] grid = { { 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0 } };
		Assert.assertEquals(5, closedIslands.closedIsland(grid));
	}
}
