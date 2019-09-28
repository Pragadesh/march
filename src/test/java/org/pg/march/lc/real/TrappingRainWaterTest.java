package org.pg.march.lc.real;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrappingRainWaterTest {

    private TrappingRainWater trappingRainWater;

    @Before
    public void setup() {
        trappingRainWater = new TrappingRainWater();
    }

    @Test
    public void testcase1() {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        Assert.assertEquals(6, trappingRainWater.trap(height));
    }

    @Test
    public void testcase2() {
        int[] height = new int[] { 4, 2, 3 };
        Assert.assertEquals(1, trappingRainWater.trap(height));
    }

    @Test
    public void testcase3() {
        int[] height = new int[] { 5, 4, 1, 2 };
        Assert.assertEquals(1, trappingRainWater.trap(height));
    }
}
