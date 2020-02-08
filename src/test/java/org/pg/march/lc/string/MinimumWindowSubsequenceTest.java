package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MinimumWindowSubsequenceTest {

	
	private MinimumWindowSubsequence minimumWindowSubsequence;

    @Before
    public void setup() {
        minimumWindowSubsequence = new MinimumWindowSubsequence();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals("bcde", minimumWindowSubsequence.minWindow("abcdebdde", "bde"));
    }
}
