package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class WildcardMatchingTest {

	private WildcardMatching wildcardMatching;

	@Before
	public void setup() {
		wildcardMatching = new WildcardMatching();
	}

	@Test
	public void testcase1() {
		Assert.assertEquals(false, wildcardMatching.isMatchForwardDP("aa", "a"));
	}

	@Test
	public void testcase2() {
		Assert.assertEquals(true, wildcardMatching.isMatchForwardDP("aa", "*"));
	}

	@Test
	public void testcase3() {
		Assert.assertEquals(false, wildcardMatching.isMatchForwardDP("cb", "?a"));
	}

	@Test
	public void testcase4() {
		Assert.assertEquals(true, wildcardMatching.isMatchForwardDP("adceb", "*a*b"));
	}

	@Test
	public void testcase5() {
		Assert.assertEquals(false, wildcardMatching.isMatchForwardDP("acdcb", "a*c?b"));
	}
	
	@Test
	public void testcase6() {
		Assert.assertEquals(false, wildcardMatching.isMatchForwardDP("aab", "c*a*b"));
	}
	
	@Test
	public void testcase7() {
		Assert.assertEquals(true, wildcardMatching.isMatchForwardDP("ho", "**ho"));
	}
}
