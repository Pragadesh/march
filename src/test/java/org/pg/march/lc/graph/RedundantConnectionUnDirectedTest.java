package org.pg.march.lc.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RedundantConnectionUnDirectedTest {

    private RedundantConnectionUnDirected redundantConnectionUnDirected;

    @Before
    public void setup() {
        redundantConnectionUnDirected = new RedundantConnectionUnDirected();
    }

    @Test
    public void testcase1() {
        int[][] edges = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[] cycleEdge = redundantConnectionUnDirected.findRedundantConnection(edges);
        Assert.assertArrayEquals(new int[] { 2, 3 }, cycleEdge);
    }

    @Test
    public void testcase2() {
        int[][] edges = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        int[] cycleEdge = redundantConnectionUnDirected.findRedundantConnection(edges);
        Assert.assertArrayEquals(new int[] { 1, 4 }, cycleEdge);
    }

    @Test
    public void testcase3() {
        int[][] edges = new int[][] { { 9, 10 }, { 5, 8 }, { 2, 6 }, { 1, 5 }, { 3, 8 }, { 4, 9 }, { 8, 10 }, { 4, 10 }, { 6, 8 }, { 7, 9 } };
        int[] cycleEdge = redundantConnectionUnDirected.findRedundantConnection(edges);
        Assert.assertArrayEquals(new int[] { 4, 10 }, cycleEdge);
    }
}
