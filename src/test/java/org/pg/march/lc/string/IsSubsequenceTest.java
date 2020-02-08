package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class IsSubsequenceTest {

    private IsSubsequence isSubsequence;

    @Before
    public void setup() {
        isSubsequence = new IsSubsequence();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(true, isSubsequence.isSubsequence("abc", "ahbgdc"));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(false, isSubsequence.isSubsequence("axc", "ahbgdc"));
    }
}
