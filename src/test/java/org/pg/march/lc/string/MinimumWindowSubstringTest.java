package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MinimumWindowSubstringTest {

    
    private MinimumWindowSubstring minimumWindowSubstring;

    @Before
    public void setup() {
        minimumWindowSubstring = new MinimumWindowSubstring();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals("BANC", minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }
}
