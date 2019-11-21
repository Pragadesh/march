package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CherryPickupTest {

	
	private CherryPickup cherryPickup;

    @Before
    public void setup() {
        cherryPickup = new CherryPickup();
    }

    @Test
    public void testcase1() {
        int[][] grid = new int[][] {
        	{0, 1, -1},
        	{1, 0, -1},
        	{1, 1,  1}};
        Assert.assertEquals(5, cherryPickup.cherryPickup(grid));
    }
    
    @Test
    public void testcase2() {
        int[][] grid = new int[][] {
        	{1,1,-1},
        	{1,-1,1},
        	{-1,1,1}};
        Assert.assertEquals(0, cherryPickup.cherryPickup(grid));
    }
    
    @Test
    public void testcase3() {
        int[][] grid = new int[][] {{1}};
        Assert.assertEquals(1, cherryPickup.cherryPickup(grid));
    }
    
    @Test
    public void testcase4() {
        int[][] grid = new int[][]
        		{{1,1,1,1,-1,-1,-1,1,0,0},
        		{1,0,0,0,1,0,0,0,1,0},
        		{0,0,1,1,1,1,0,1,1,1},
        		{1,1,0,1,1,1,0,-1,1,1},
        		{0,0,0,0,1,-1,0,0,1,-1},
        		{1,0,1,1,1,0,0,-1,1,0},
        		{1,1,0,1,0,0,1,0,1,-1},
        		{1,-1,0,1,0,0,0,1,-1,1},
        		{1,0,-1,0,-1,0,0,1,0,0},
        		{0,0,-1,0,1,0,1,0,0,1}};
        Assert.assertEquals(1, cherryPickup.cherryPickup(grid));
    }
}
