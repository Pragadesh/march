package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LongestPalindromicSubstringTest {

	private LongestPalindromicSubstring longestPalindromicSubstring;

    @Before
    public void setup() {
        longestPalindromicSubstring = new LongestPalindromicSubstring();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals("bab", longestPalindromicSubstring.longestPalindrome("babad"));
    }
    
    @Test
    public void testcase2() {
        Assert.assertEquals("bb", longestPalindromicSubstring.longestPalindrome("cbbd"));
    }
    
    @Test
    public void testcase3() {
        Assert.assertEquals("a", longestPalindromicSubstring.longestPalindrome("a"));
    }
    
    @Test
    public void testcase4() {
        Assert.assertEquals("bb", longestPalindromicSubstring.longestPalindrome("bb"));
    }
    
    @Test
    public void testcase5() {
        Assert.assertEquals("ccc", longestPalindromicSubstring.longestPalindrome("ccc"));
    }
    
    @Test
    public void testcase6() {
        Assert.assertEquals("aaaa", longestPalindromicSubstring.longestPalindrome("aaaa"));
    }
    
    @Test
    public void testcase7() {
        Assert.assertEquals("a", longestPalindromicSubstring.longestPalindrome("abcda"));
    }
    
    @Test
    public void testcase8() {
        Assert.assertEquals("axabaxa", longestPalindromicSubstring.longestPalindrome("axabaxa"));
    }
}
