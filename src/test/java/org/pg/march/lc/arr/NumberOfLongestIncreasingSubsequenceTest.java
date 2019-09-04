package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/*
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 */
public class NumberOfLongestIncreasingSubsequenceTest {

    private NumberOfLongestIncreasingSubsequence longestIncreasingSubsequence;

    @Before
    public void setup() {
        longestIncreasingSubsequence = new NumberOfLongestIncreasingSubsequence();
    }

    @Test
    public void testCase1() {
        int[] nums = { 1, 3, 5, 4, 7 };
        Assert.assertEquals(2, longestIncreasingSubsequence.findNumberOfLIS(nums));
    }

    @Test
    public void testCase2() {
        int[] nums = { 2, 2, 2, 2, 2 };
        Assert.assertEquals(5, longestIncreasingSubsequence.findNumberOfLIS(nums));
    }

    @Test
    public void testCase3() {
        int[] nums = { 1, 2, 4, 3, 5, 4, 7, 2 };
        Assert.assertEquals(3, longestIncreasingSubsequence.findNumberOfLIS(nums));
    }
}
