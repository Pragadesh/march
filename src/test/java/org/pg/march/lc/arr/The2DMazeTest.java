package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class The2DMazeTest {

	private The2DMaze the2DMaze;

    @Before
    public void setup() {
        the2DMaze = new The2DMaze();
    }

    @Test
    public void testcase1() {
        int[][] maze = {
        		{0,0,1,0,0},
        		{0,0,0,0,0},
        		{0,0,0,1,0},
        		{1,1,0,1,1},
        		{0,0,0,0,0}
        		};
        Assert.assertEquals(12, the2DMaze.shortestDistance(maze, new int[] {0,4}, new int[] {4,4}));
    }
    
    @Test
    public void testcase2() {
        int[][] maze = {
        		{0,0,0,0,0},
        		{1,1,0,0,1},
        		{0,0,0,0,0},
        		{0,1,0,0,1},
        		{0,1,0,0,0}
        		};
        Assert.assertEquals("lul", the2DMaze.findShortestWay(maze, new int[] {4,3}, new int[] {0,1}));
    }
    
    @Test
    public void testcase3() {
        int[][] maze = {
        		{0,0,0,0,0},
        		{1,1,0,0,1},
        		{0,0,0,0,0},
        		{0,1,0,0,1},
        		{0,1,0,0,0}
        		};
        Assert.assertEquals("impossible", the2DMaze.findShortestWay(maze, new int[] {4,3}, new int[] {3,0}));
    }
}
