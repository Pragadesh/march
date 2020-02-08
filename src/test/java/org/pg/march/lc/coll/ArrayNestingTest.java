package org.pg.march.lc.coll;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ArrayNestingTest {

	ArrayNesting arrayNesting;

	@Before
	public void setup() {
		arrayNesting = new ArrayNesting();
	}

	@Test
	public void testcase1() {
		int[] nums = new int[] { 5, 4, 0, 3, 1, 6, 2 };
		Assert.assertEquals(4, arrayNesting.arrayNesting(nums));
	}
	@Test
	public void testcase2() {
		int[] nums = new int[] { 1,0,3,4,2 };
		Assert.assertEquals(3, arrayNesting.arrayNesting(nums));
	}
}
