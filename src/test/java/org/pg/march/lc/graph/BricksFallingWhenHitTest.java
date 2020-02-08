package org.pg.march.lc.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BricksFallingWhenHitTest {

	private BricksFallingWhenHit bricksFallingWhenHit;

	@Before
	public void setup() {
		bricksFallingWhenHit = new BricksFallingWhenHit();
	}

	@Test
	public void testcase1() {
		int[][] grid = { { 1, 0, 0, 0 }, { 1, 1, 1, 0 } };
		int[] res = bricksFallingWhenHit.hitBricks(grid, new int[][] { { 1, 0 } });
		Assert.assertArrayEquals(new int[] { 2 }, res);
	}

	@Test
	public void testcase2() {
		int[][] grid = { { 1, 0, 0, 0 }, { 1, 1, 0, 0 } };
		int[] res = bricksFallingWhenHit.hitBricks(grid, new int[][] { { 1, 1 }, { 1, 0 } });
		Assert.assertArrayEquals(new int[] { 0, 0 }, res);
	}
}
