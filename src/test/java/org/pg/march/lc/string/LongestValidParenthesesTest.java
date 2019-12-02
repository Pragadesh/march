package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LongestValidParenthesesTest {

	private LongestValidParentheses longestValidParentheses;

    @Before
    public void setup() {
        longestValidParentheses = new LongestValidParentheses();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(2, longestValidParentheses.longestValidParentheses("(()"));
    }
    
    @Test
    public void testcase2() {
        Assert.assertEquals(4, longestValidParentheses.longestValidParentheses(")()())"));
    }
    
    @Test
    public void testcase3() {
    	Assert.assertEquals(4, longestValidParentheses.longestValidParentheses(")()())()()("));
    }
    
    @Test
    public void testcase4() {
    	Assert.assertEquals(6, longestValidParentheses.longestValidParentheses("(())()(()(("));
    }
    
    @Test
    public void testcase5() {
    	Assert.assertEquals(4, longestValidParentheses.longestValidParentheses(")()())"));
    }
}
