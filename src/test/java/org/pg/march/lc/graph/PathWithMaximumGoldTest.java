package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class PathWithMaximumGoldTest {

    private PathWithMaximumGold pathWithMaximumGold;

    @Before
    public void setup() {
        pathWithMaximumGold = new PathWithMaximumGold();
    }

    @Test
    public void testcase1() {
        int[][] grid = new int[][] {
            {0,6,0},
            {5,8,7},
            {0,9,0}};
        Assert.assertEquals(24, pathWithMaximumGold.getMaximumGold(grid));
    }
    
    @Test
    public void testcase2() {
        int[][] grid = new int[][] {
            {1,0,7},
            {2,0,6},
            {3,4,5},
            {0,3,0},
            {9,0,20}};
        Assert.assertEquals(28, pathWithMaximumGold.getMaximumGold(grid));
    }
}
