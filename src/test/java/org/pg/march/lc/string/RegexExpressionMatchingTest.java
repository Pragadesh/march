package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class RegexExpressionMatchingTest {

    private RegexExpressionMatching regexExpressionMatching;

    @Before
    public void setup() {
        regexExpressionMatching = new RegexExpressionMatching();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(false, regexExpressionMatching.isMatch("aa", "a"));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(true, regexExpressionMatching.isMatch("aa", "a*"));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(true, regexExpressionMatching.isMatch("ab", ".*"));
    }

    @Test
    public void testcase4() {
        Assert.assertEquals(true, regexExpressionMatching.isMatch("aab", "c*a*b"));
    }

    @Test
    public void testcase5() {
        Assert.assertEquals(false, regexExpressionMatching.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    public void testcase6() {
        Assert.assertEquals(true, regexExpressionMatching.isMatch("", ".*"));
    }

    @Test
    public void testcase7() {
        Assert.assertEquals(true, regexExpressionMatching.isMatch("", ""));
    }

}
