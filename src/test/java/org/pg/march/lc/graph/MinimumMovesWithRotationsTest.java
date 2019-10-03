package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MinimumMovesWithRotationsTest {

    private MinimumMovesWithRotations minimumMovesWithRotations;

    @Before
    public void setup() {
        minimumMovesWithRotations = new MinimumMovesWithRotations();
    }

    @Test
    public void testcase1() {
        int[][] grids = new int[][] {
            {0,0,0,0,0,1},
            {1,1,0,0,1,0},
            {0,0,0,0,1,1},
            {0,0,1,0,1,0},
            {0,1,1,0,0,0},
            {0,1,1,0,0,0}};
        Assert.assertEquals(11, minimumMovesWithRotations.minimumMoves(grids));
    }
    
    @Test
    public void testcase2() {
        int[][] grids = new int[][] {
            {0,0,1,1,1,1},
            {0,0,0,0,1,1},
            {1,1,0,0,0,1},
            {1,1,1,0,0,1},
            {1,1,1,0,0,1},
            {1,1,1,0,0,0}};
        Assert.assertEquals(9, minimumMovesWithRotations.minimumMoves(grids));
    }
    
    @Test
    public void testcase3() {
        int[][] grids = new int[][] {
            {0,0,0,0,0,0,0,0,0,1},
            {0,1,0,0,0,0,0,1,0,1},
            {1,0,0,1,0,0,1,0,1,0},
            {0,0,0,1,0,1,0,1,0,0},
            {0,0,0,0,1,0,0,0,0,1},
            {0,0,1,0,0,0,0,0,0,0},
            {1,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {1,1,0,0,0,0,0,0,0,0}};
        Assert.assertEquals(-1, minimumMovesWithRotations.minimumMoves(grids));
    }
}
