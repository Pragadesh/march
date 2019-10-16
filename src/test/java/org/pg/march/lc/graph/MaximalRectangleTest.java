package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MaximalRectangleTest {

    private MaximalRectangle maximalRectangle;

    @Before
    public void setup() {
        maximalRectangle = new MaximalRectangle();
    }

    @Test
    public void testcase1() {
        char[][] matrix = new char[][] {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
          };
        Assert.assertEquals(6, maximalRectangle.maximalRectangle(matrix));
    }
    
    @Test
    public void testcase2() {
        char[][] matrix = new char[][] { { '1', '1' } };
        Assert.assertEquals(2, maximalRectangle.maximalRectangle(matrix));
    }
}
