package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ShortestPalindromeTest {

    private ShortestPalindrome shortestPalindrome;

    @Before
    public void setup() {
        shortestPalindrome = new ShortestPalindrome();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals("aaacecaaa", shortestPalindrome.shortestPalindrome("aacecaaa"));
    }
    
    @Test
    public void testcase2() {
        Assert.assertEquals("dcbabcd", shortestPalindrome.shortestPalindrome("abcd"));
    }
}
