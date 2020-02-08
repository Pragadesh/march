package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MinimumSwapsMakeSequencesIncreasingTest {

    private MinimumSwapsMakeSequencesIncreasing minimumSwapsMakeSequencesIncreasing;

    @Before
    public void setup() {
        minimumSwapsMakeSequencesIncreasing = new MinimumSwapsMakeSequencesIncreasing();
    }

    @Test
    public void testcase1() {
        int[] A = { 1, 3, 5, 4 };
        int[] B = { 1, 2, 3, 7 };
        Assert.assertEquals(1, minimumSwapsMakeSequencesIncreasing.minSwap(A, B));
    }
}
