package org.pg.march.lc.game;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SlidingPuzzleTest {

    private SlidingPuzzle slidingPuzzle;

    @Before
    public void setup() {
        slidingPuzzle = new SlidingPuzzle();
    }

    @Test
    public void testcase1() {
        int[][] board = { { 1, 2, 3 }, { 4, 0, 5 } };
        Assert.assertEquals(1, slidingPuzzle.slidingPuzzle(board));
    }

    @Test
    public void testcase2() {
        int[][] board = { { 1, 2, 3 }, { 5, 4, 0 } };
        Assert.assertEquals(-1, slidingPuzzle.slidingPuzzle(board));
    }

    @Test
    public void testcase3() {
        int[][] board = { { 4, 1, 2 }, { 5, 0, 3 } };
        Assert.assertEquals(5, slidingPuzzle.slidingPuzzle(board));
    }
}
