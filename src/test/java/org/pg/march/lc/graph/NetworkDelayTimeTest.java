package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class NetworkDelayTimeTest {

	private NetworkDelayTime networkDelayTime;

	@Before
	public void setup() {
		networkDelayTime = new NetworkDelayTime();
	}

	@Test
	public void testcase1() {
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		Assert.assertEquals(2, networkDelayTime.networkDelayTime(times, 4, 2));
	}
}
