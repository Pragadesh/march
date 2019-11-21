package org.pg.march.lc.game;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class UniquePathsIITest {

	private UniquePathsII uniquePathsII;

	@Before
	public void setup() {
		uniquePathsII = new UniquePathsII();
	}

	@Test
	public void testcase1() {
		int[][] obstacleGrid = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		Assert.assertEquals(2, uniquePathsII.uniquePathsWithObstacles(obstacleGrid));
	}

}
