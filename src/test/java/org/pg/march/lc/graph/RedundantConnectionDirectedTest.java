package org.pg.march.lc.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RedundantConnectionDirectedTest {

    private RedundantConnectionDirected redundantConnectionDirected;

    @Before
    public void setup() {
        redundantConnectionDirected = new RedundantConnectionDirected();
    }

    @Test
    public void testcase1() {
        int[][] edges = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[] cycleEdge = redundantConnectionDirected.findRedundantDirectedConnection(edges);
        Assert.assertArrayEquals(new int[] { 2, 3 }, cycleEdge);
    }

    @Test
    public void testcase2() {
        int[][] edges = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        int[] cycleEdge = redundantConnectionDirected.findRedundantDirectedConnection(edges);
        Assert.assertArrayEquals(new int[] { 1, 4 }, cycleEdge);
    }

    @Test
    public void testcase3() {
        int[][] edges = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 5 } };
        int[] cycleEdge = redundantConnectionDirected.findRedundantDirectedConnection(edges);
        Assert.assertArrayEquals(new int[] { 4, 1 }, cycleEdge);
    }
}
