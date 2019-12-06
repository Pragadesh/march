package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ReachingPointsTest {

	private ReachingPoints reachingPoints;

	@Before
	public void setup() {
		reachingPoints = new ReachingPoints();
	}

	@Test
	public void testcase1() {
		Assert.assertEquals(true, reachingPoints.reachingPoints(1, 1, 3, 5));
	}

	@Test
	public void testcase2() {
		Assert.assertEquals(false, reachingPoints.reachingPoints(1, 1, 2, 2));
	}

	@Test
	public void testcase3() {
		Assert.assertEquals(true, reachingPoints.reachingPoints(1, 1, 1, 1));
	}
}
