package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SplitArrayLargestSumTest {

	private SplitArrayLargestSum splitArrayLargestSum;

	@Before
	public void setup() {
		splitArrayLargestSum = new SplitArrayLargestSum();
	}

	@Test
	public void testcase1() {
		int[] nums = { 7, 2, 5, 10, 8 };
		Assert.assertEquals(18, splitArrayLargestSum.splitArray(nums, 2));
	}
}
