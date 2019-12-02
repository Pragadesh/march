package org.pg.march.lc.coll;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SlidingWindowMedianTest {

	private SlidingWindowMedian slidingWindowMedian;

	@Before
	public void setup() {
		slidingWindowMedian = new SlidingWindowMedian();
	}

	@Test
	public void testcase1() {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		double[] median = slidingWindowMedian.medianSlidingWindow(nums, 3);
		double[] expected = new double[] { 1, -1, -1, 3, 5, 6 };
		Assert.assertTrue(Arrays.equals(median, expected));
	}
}
