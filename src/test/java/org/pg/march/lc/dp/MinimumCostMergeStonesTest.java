package org.pg.march.lc.dp;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MinimumCostMergeStonesTest {

    MinimumCostMergeStones minimumCostMergeStones;

    @Before
    public void setup() {
        minimumCostMergeStones = new MinimumCostMergeStones();
    }

    @Test
    public void testcase1() {
        int[] stones = { 3, 2, 4, 1 };
        Assert.assertEquals(20, minimumCostMergeStones.mergeStones(stones, 2));
    }

    @Test
    public void testcase2() {
        int[] stones = { 3, 2, 4, 1 };
        Assert.assertEquals(-1, minimumCostMergeStones.mergeStones(stones, 3));
    }

    @Test
    public void testcase3() {
        int[] stones = { 3, 5, 1, 2, 6 };
        Assert.assertEquals(25, minimumCostMergeStones.mergeStones(stones, 3));
    }
    
    @Test
    public void testcase4() {
        int[] stones = { 3, 5, 1, 2, 6 };
        Assert.assertEquals(25, minimumCostMergeStones.mergeStones(stones, 3));
    }
}
