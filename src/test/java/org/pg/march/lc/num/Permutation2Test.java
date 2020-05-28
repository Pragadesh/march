package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;

public class Permutation2Test {

	private Permutation2 permutation2;

	@Before
	public void setup() {
		permutation2 = new Permutation2();
	}

	@Test
	public void testcase1() {
		int[] nums = { 1, 1, 2 };
		System.out.println(permutation2.permuteUnique(nums));
	}
}
