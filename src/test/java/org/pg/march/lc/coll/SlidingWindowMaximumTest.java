package org.pg.march.lc.coll;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SlidingWindowMaximumTest {

    private SlidingWindowMaximum slidingWindowMaximum;

    @Before
    public void setup() {
        slidingWindowMaximum = new SlidingWindowMaximum();
    }

    @Test
    public void testcase1() {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int[] max = slidingWindowMaximum.maxSlidingWindow(nums, 3);
        int[] expected = new int[] { 3, 3, 5, 5, 6, 7 };
        Assert.assertTrue(Arrays.equals(max, expected));
    }

    @Test
    public void testcase2() {
        int[] nums = { 1, 6, 10, 8 };
        int[] max = slidingWindowMaximum.maxSlidingWindow(nums, 3);
        int[] expected = new int[] { 3, 3, 5, 5, 6, 7 };
        Assert.assertTrue(Arrays.equals(max, expected));
    }
}
