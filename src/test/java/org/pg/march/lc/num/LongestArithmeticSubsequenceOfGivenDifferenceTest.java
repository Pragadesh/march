package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LongestArithmeticSubsequenceOfGivenDifferenceTest {

    private LongestArithmeticSubsequenceOfGivenDifference longestArithmeticSubsequence;

    @Before
    public void setup() {
        longestArithmeticSubsequence = new LongestArithmeticSubsequenceOfGivenDifference();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(1, longestArithmeticSubsequence.longestSubsequence(new int[] { 1, 3, 5, 7 }, 1));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(4, longestArithmeticSubsequence.longestSubsequence(new int[] { 1, 5, 7, 8, 5, 3, 4, 2, 1 }, -2));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(4, longestArithmeticSubsequence.longestSubsequence(new int[] { 1, 2, 3, 4 }, 1));
    }
}
