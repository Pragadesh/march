package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MaximumEqualFrequencyTest {

    private MaximumEqualFrequency maximumEqualFrequency;

    @Before
    public void setup() {
        maximumEqualFrequency = new MaximumEqualFrequency();
    }

    @Test
    public void testcase1() {
        int[] nums = { 2, 2, 1, 1, 5, 3, 3, 5 };
        Assert.assertEquals(7, maximumEqualFrequency.maxEqualFreq(nums));
    }

    @Test
    public void testcase2() {
        int[] nums = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5 };
        Assert.assertEquals(13, maximumEqualFrequency.maxEqualFreq(nums));
    }

    @Test
    public void testcase3() {
        int[] nums = { 1, 1, 1, 2, 2, 2 };
        Assert.assertEquals(3, maximumEqualFrequency.maxEqualFreq(nums));
    }

    @Test
    public void testcase4() {
        int[] nums = { 10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6 };
        Assert.assertEquals(8, maximumEqualFrequency.maxEqualFreq(nums));
    }
}
