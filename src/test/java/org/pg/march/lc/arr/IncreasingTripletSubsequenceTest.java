package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class IncreasingTripletSubsequenceTest {

    private IncreasingTripletSubsequence increasingTripletSubsequence;

    @Before
    public void setup() {
        increasingTripletSubsequence = new IncreasingTripletSubsequence();
    }

    @Test
    public void testCase1() {
        int[] nums = { 1, 2, 3, 4, 5 };
        Assert.assertEquals(true, increasingTripletSubsequence.increasingTriplet(nums));
    }

    @Test
    public void testCase2() {
        int[] nums = { 5, 4, 3, 2, 1 };
        Assert.assertEquals(false, increasingTripletSubsequence.increasingTriplet(nums));
    }

    @Test
    public void testCase3() {
        int[] nums = { 5, 1, 5, 5, 2, 5, 4 };
        Assert.assertEquals(true, increasingTripletSubsequence.increasingTriplet(nums));
    }
}
