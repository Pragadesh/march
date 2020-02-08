package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MinimumCostConnectSticksTest {

	private MinimumCostConnectSticks minimumCostConnectSticks;

	@Before
	public void setup() {
		minimumCostConnectSticks = new MinimumCostConnectSticks();
	}

	@Test
	public void testcase1() {
		int[] sticks = { 2, 4, 3 };
		Assert.assertEquals(14, minimumCostConnectSticks.connectSticks(sticks));
	}

	@Test
	public void testcase2() {
		int[] sticks = { 1, 8, 3, 5 };
		Assert.assertEquals(30, minimumCostConnectSticks.connectSticks(sticks));
	}
}
