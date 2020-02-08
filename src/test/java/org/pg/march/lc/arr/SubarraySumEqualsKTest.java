package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SubarraySumEqualsKTest {

	private SubarraySumEqualsK subarraySumEqualsK;

	@Before
	public void setup() {
		subarraySumEqualsK = new SubarraySumEqualsK();
	}

	@Test
	public void testcase1() {
		int[] nums = { 1, 1, 1 };
		Assert.assertEquals(2, subarraySumEqualsK.subarraySum(nums, 2));
	}
	
	@Test
	public void testcase2() {
		int[] nums = { 1, 2, 3 };
		Assert.assertEquals(2, subarraySumEqualsK.subarraySum(nums, 3));
	}
	
	@Test
	public void testcase3() {
		int[] nums = { -1, -1, 1 };
		Assert.assertEquals(1, subarraySumEqualsK.subarraySum(nums, 0));
	}
}
