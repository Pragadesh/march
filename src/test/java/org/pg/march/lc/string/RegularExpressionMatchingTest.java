package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class RegularExpressionMatchingTest {

	private RegularExpressionMatching regularExpressionMatching;

	@Before
	public void setup() {
		regularExpressionMatching = new RegularExpressionMatching();
	}

	@Test
	public void testcase1() {
		Assert.assertEquals(false, regularExpressionMatching.isMatch("aa", "a"));
	}

	@Test
	public void testcase2() {
		Assert.assertEquals(true, regularExpressionMatching.isMatch("aa", "a*"));
	}

	@Test
	public void testcase3() {
		Assert.assertEquals(true, regularExpressionMatching.isMatch("ab", ".*"));
	}

	@Test
	public void testcase4() {
		Assert.assertEquals(true, regularExpressionMatching.isMatch("aab", "c*a*b"));
	}

	@Test
	public void testcase5() {
		Assert.assertEquals(false, regularExpressionMatching.isMatch("mississippi", "mis*is*p*."));
	}
	
	@Test
	public void testcase6() {
		Assert.assertEquals(true, regularExpressionMatching.isMatch("mississippi", "mis*is*ip*."));
	}
	
	@Test
	public void testcase7() {
		Assert.assertEquals(true, regularExpressionMatching.isMatch("aaa", "ab*ac*a"));
	}
}
