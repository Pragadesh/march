package org.pg.march.lc.string;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

import junit.framework.Assert;

public class MinimumRemoveMakeValidParenthesesTest {

	private MinimumRemoveMakeValidParentheses minimumRemoveMakeValidParentheses;

	@Before
	public void setup() {
		minimumRemoveMakeValidParentheses = new MinimumRemoveMakeValidParentheses();
	}

	@Test
	public void testcase1() {
		String validStr = minimumRemoveMakeValidParentheses.minRemoveToMakeValid("lee(t(c)o)de)");
		Set<String> expected = Sets.newHashSet("lee(t(c)o)de", "lee(t(co)de)", "lee(t(c)ode)");
		Assert.assertTrue("Output: " + validStr, expected.contains(validStr));
	}

	@Test
	public void testcase2() {
		Assert.assertEquals("ab(c)d", minimumRemoveMakeValidParentheses.minRemoveToMakeValid("a)b(c)d"));
	}

	@Test
	public void testcase3() {
		Assert.assertEquals("", minimumRemoveMakeValidParentheses.minRemoveToMakeValid("))(("));
	}

}
