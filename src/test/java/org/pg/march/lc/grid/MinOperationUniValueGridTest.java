package org.pg.march.lc.grid;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinOperationUniValueGridTest {

    private MinOperationUniValueGrid minOperationUniValueGrid;

    @Before
    public void setup() {
        minOperationUniValueGrid = new MinOperationUniValueGrid();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(4, minOperationUniValueGrid.minOperations(new int[][] {{2,4}, {6,8}} ,2));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(5, minOperationUniValueGrid.minOperations(new int[][] {{1,5}, {2,3}} ,1));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(-1, minOperationUniValueGrid.minOperations(new int[][] {{1,2}, {3,4}} ,2));
    }

    @Test
    public void testcase4() {
        Assert.assertEquals(0, minOperationUniValueGrid.minOperations(new int[][] {{146}} ,86));
    }

    @Test
    public void testcase5() {
        Assert.assertEquals(473, minOperationUniValueGrid.minOperations(new int[][] {{596,904,960,232,120,932,176},{372,792,288,848,960,960,764},{652,92,904,120,680,904,120},{372,960,92,680,876,624,904},{176,652,64,344,316,764,316},{820,624,848,596,960,960,372},{708,120,456,92,484,932,540}} ,28));
    }
}
