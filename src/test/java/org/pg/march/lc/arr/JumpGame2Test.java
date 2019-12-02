package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class JumpGame2Test {

	private JumpGame2 jumpGame2;

	@Before
	public void setup() {
		jumpGame2 = new JumpGame2();
	}

	@Test
	public void testcase1() {
		int[] nums = { 2, 3, 1, 1, 4 };
		Assert.assertEquals(2, jumpGame2.jump(nums));
	}

	@Test
	public void testcase2() {
		int[] nums = { 1, 1, 1, 1 };
		Assert.assertEquals(3, jumpGame2.jump(nums));
		char c = 'a';
		System.out.println(c);
		c ^= 256;
		System.out.println(c);
		c ^= 256;
		System.out.println(c);
	}
}
