package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SplitArrayIntoConsecutiveSubsequencesTest {

	private SplitArrayIntoConsecutiveSubsequences splitArrayConsecutiveSubsequences;

	@Before
	public void setup() {
		splitArrayConsecutiveSubsequences = new SplitArrayIntoConsecutiveSubsequences();
	}

	@Test
	public void testcase1() {
		int[] nums = { 1, 2, 3, 3, 4, 5 };
		Assert.assertEquals(true, splitArrayConsecutiveSubsequences.isPossible(nums));
	}

	@Test
	public void testcase2() {
		int[] nums = { 1, 2, 3, 3, 4, 4, 5, 5 };
		Assert.assertEquals(true, splitArrayConsecutiveSubsequences.isPossible(nums));
	}

	@Test
	public void testcase3() {
		int[] nums = { 1, 2, 3, 4, 4, 5 };
		Assert.assertEquals(false, splitArrayConsecutiveSubsequences.isPossible(nums));
	}

	@Test
	public void testcase4() {
		int[] nums = { 10, 10, 11, 11, 11, 11, 12, 12, 12, 12, 13 };
		Assert.assertEquals(false, splitArrayConsecutiveSubsequences.isPossible(nums));
	}
}
