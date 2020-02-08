package org.pg.march.lc.greedy;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class OptimalAccountBalancingTest {

    private OptimalAccountBalancing optimalAccountBalancing;

    @Before
    public void setup() {
        optimalAccountBalancing = new OptimalAccountBalancing();
    }

    @Test
    public void testcase1() {
        int[][] transactions = { { 0, 1, 10 }, { 2, 0, 5 } };
        Assert.assertEquals(2, optimalAccountBalancing.minTransfers(transactions));
    }

    @Test
    public void testcase2() {
        int[][] transactions = { { 0, 1, 10 }, { 1, 0, 1 }, { 1, 2, 5 }, { 2, 0, 5 } };
        Assert.assertEquals(1, optimalAccountBalancing.minTransfers(transactions));
    }
}
