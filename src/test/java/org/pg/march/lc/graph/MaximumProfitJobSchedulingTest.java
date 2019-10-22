package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MaximumProfitJobSchedulingTest {

	private MaximumProfitJobScheduling maximumProfitJobScheduling;

	@Before
	public void setup() {
		maximumProfitJobScheduling = new MaximumProfitJobScheduling();
	}

	@Test
	public void testcase1() {
		int[] startTime = { 1, 2, 3, 3 };
		int[] endTime = { 3, 4, 5, 6 };
		int[] profit = { 50, 10, 40, 70 };
		Assert.assertEquals(120, maximumProfitJobScheduling.jobScheduling(startTime, endTime, profit));
	}

	@Test
	public void testcase2() {
		int[] startTime = { 1, 2, 3, 4, 6 };
		int[] endTime = { 3, 5, 10, 6, 9 };
		int[] profit = { 20, 20, 100, 70, 60 };
		Assert.assertEquals(150, maximumProfitJobScheduling.jobScheduling(startTime, endTime, profit));
	}

	@Test
	public void testcase3() {
		int[] startTime = { 1, 1, 1 };
		int[] endTime = { 2, 3, 4 };
		int[] profit = { 5, 6, 4 };
		Assert.assertEquals(6, maximumProfitJobScheduling.jobScheduling(startTime, endTime, profit));
	}
}
