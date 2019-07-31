package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class FirstPositiveTest {

	private FirstPositive firstPositive;

	@Before
	public void setup() {
		firstPositive = new FirstPositive();
	}

	@Test
	public void testCase1() {
		int[] nums = { 3, 4, -1, 1 };
		Assert.assertEquals(2, firstPositive.firstMissingPositive(nums));
	}

	@Test
	public void testCase2() {
		int[] nums = { 1, 2, 0 };
		Assert.assertEquals(3, firstPositive.firstMissingPositive(nums));
	}

	@Test
	public void testCase3() {
		int[] nums = { 7, 8, 9, 11, 12 };
		Assert.assertEquals(1, firstPositive.firstMissingPositive(nums));
	}
	
	   @Test
	    public void testCase4() {
	        int[] nums = { 2, 1};
	        Assert.assertEquals(3, firstPositive.firstMissingPositive(nums));
	    }
}
