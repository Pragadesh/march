package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class InterleavingStringTest {

	private InterleavingString interleavingString;

	@Before
	public void setup() {
		interleavingString = new InterleavingString();
	}

	@Test
	public void testcase1() {
		Assert.assertEquals(true, interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
	
	@Test
	public void testcase2() {
		Assert.assertEquals(false, interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
