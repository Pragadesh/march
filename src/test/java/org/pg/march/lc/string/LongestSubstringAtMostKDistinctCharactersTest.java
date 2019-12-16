package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LongestSubstringAtMostKDistinctCharactersTest {

    private LongestSubstringAtMostKDistinctCharacters longestSubstring;

    @Before
    public void setup() {
        longestSubstring = new LongestSubstringAtMostKDistinctCharacters();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(3, longestSubstring.lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(2, longestSubstring.lengthOfLongestSubstringKDistinct("aa", 1));
    }
}
