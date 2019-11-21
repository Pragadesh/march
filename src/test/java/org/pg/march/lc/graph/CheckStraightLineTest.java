package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CheckStraightLineTest {

    private CheckStraightLine checkStraightLine;

    @Before
    public void setup() {
        checkStraightLine = new CheckStraightLine();
    }

    @Test
    public void testcase1() {
        int[][] coordinates = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
        Assert.assertEquals(true, checkStraightLine.checkStraightLine(coordinates));
    }
    
    @Test
    public void testcase2() {
        int[][] coordinates = { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } };
        Assert.assertEquals(false, checkStraightLine.checkStraightLine(coordinates));
    }
}
