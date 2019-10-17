package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LargestRectangleInHistogramTest {

    private LargestRectangleInHistogram largestRectangleInHistogram;

    @Before
    public void setup() {
        largestRectangleInHistogram = new LargestRectangleInHistogram();
    }

    @Test
    public void testcase1() {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        Assert.assertEquals(10, largestRectangleInHistogram.largestRectangleArea(heights));
    }
    
    @Test
    public void testcase2() {
        int[] heights = { 2, 1, 2 };
        Assert.assertEquals(3, largestRectangleInHistogram.largestRectangleArea(heights));
    }
}
