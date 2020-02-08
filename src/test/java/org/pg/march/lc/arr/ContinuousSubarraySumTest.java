package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ContinuousSubarraySumTest {

	ContinuousSubarraySum continuousSubarraySum;

	@Before
	public void setup() {
		continuousSubarraySum = new ContinuousSubarraySum();
	}

	@Test
	public void testcase1() {
		int[] nums = { 23, 2, 4, 6, 7 };
		Assert.assertEquals(true, continuousSubarraySum.checkSubarraySum(nums, 6));
	}
	
	@Test
	public void testcase2() {
		int[] nums = { 23, 2, 6, 4, 7 };
		Assert.assertEquals(true, continuousSubarraySum.checkSubarraySum(nums, 6));
	}
	
}
