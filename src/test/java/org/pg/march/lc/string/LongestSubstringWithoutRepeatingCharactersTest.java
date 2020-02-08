package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LongestSubstringWithoutRepeatingCharactersTest {

    private LongestSubstringWithoutRepeatingCharacters longestSubstring;

    @Before
    public void setup() {
        longestSubstring = new LongestSubstringWithoutRepeatingCharacters();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(3, longestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(1, longestSubstring.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(3, longestSubstring.lengthOfLongestSubstring("pwwkew"));
    }
}
