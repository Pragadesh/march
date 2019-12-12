package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MaxPointsOnLineTest {

	private MaxPointsOnLine maxPointsOnLine;

	@Before
	public void setup() {
		maxPointsOnLine = new MaxPointsOnLine();
	}

	@Test
	public void testcase1() {
		int[][] points = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } };
		Assert.assertEquals(3, maxPointsOnLine.maxPoints(points));
	}

	@Test
	public void testcase2() {
		int[][] points = new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
		Assert.assertEquals(4, maxPointsOnLine.maxPoints(points));
	}
}
