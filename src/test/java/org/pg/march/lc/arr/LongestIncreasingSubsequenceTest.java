package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LongestIncreasingSubsequenceTest {

    private LongestIncreasingSubsequence longestIncreasingSubsequence;

    @Before
    public void setup() {
        longestIncreasingSubsequence = new LongestIncreasingSubsequence();
    }

    @Test
    public void testCase1() {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        Assert.assertEquals(4, longestIncreasingSubsequence.lengthOfLIS(nums));
    }

    @Test
    public void testCase2() {
        int[] nums = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
        Assert.assertEquals(6, longestIncreasingSubsequence.lengthOfLIS(nums));
    }

    @Test
    public void testCase3() {
        int[] nums = { 7, 8, 9, 8, 9, 10 };
        Assert.assertEquals(6, longestIncreasingSubsequence.lengthOfLIS(nums));
    }
}
