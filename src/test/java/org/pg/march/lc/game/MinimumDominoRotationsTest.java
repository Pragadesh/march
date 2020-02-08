package org.pg.march.lc.game;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MinimumDominoRotationsTest {

    private MinimumDominoRotations minimumDominoRotations;

    @Before
    public void setup() {
        minimumDominoRotations = new MinimumDominoRotations();
    }

    @Test
    public void testcase1() {
        int[] A = { 2, 1, 2, 4, 2, 2 };
        int[] B = { 5, 2, 6, 2, 3, 2 };
        Assert.assertEquals(2, minimumDominoRotations.minDominoRotations(A, B));
    }

    @Test
    public void testcase2() {
        int[] A = { 3, 5, 1, 2, 3 };
        int[] B = { 3, 6, 3, 3, 4 };
        Assert.assertEquals(-1, minimumDominoRotations.minDominoRotations(A, B));
    }
    
    @Test
    public void testcase3() {
        int[] A = { 2, 5, 1, 2, 3 };
        int[] B = { 1, 6, 2, 2, 2 };
        Assert.assertEquals(-1, minimumDominoRotations.minDominoRotationsSoln2(A, B));
    }
}
