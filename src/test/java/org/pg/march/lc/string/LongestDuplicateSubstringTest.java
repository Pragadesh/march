package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LongestDuplicateSubstringTest {

    private LongestDuplicateSubstring longestDuplicateSubstring;

    @Before
    public void setup() {
        longestDuplicateSubstring = new LongestDuplicateSubstring();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals("ana", longestDuplicateSubstring.longestDupSubstring("banana"));
    }
    
    @Test
    public void testcase2() {
        Assert.assertEquals("", longestDuplicateSubstring.longestDupSubstring("abcd"));
    }
    
    @Test
    public void testcase3() {
        longestDuplicateSubstring.searchForLength("abcd", 2);
    }
}
