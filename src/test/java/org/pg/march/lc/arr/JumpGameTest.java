package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class JumpGameTest {

	private JumpGame jumpGame;

	@Before
	public void setup() {
		jumpGame = new JumpGame();
	}

	@Test
	public void testcase1() {
		int[] nums = { 2, 3, 1, 1, 4 };
		Assert.assertEquals(true, jumpGame.canJump(nums));
	}

	@Test
	public void testcase2() {
		int[] nums = { 3, 2, 1, 0, 4 };
		Assert.assertEquals(false, jumpGame.canJump(nums));
	}
}
