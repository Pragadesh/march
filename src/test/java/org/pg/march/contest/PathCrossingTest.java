package org.pg.march.contest;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class PathCrossingTest {

    PathCrossing pathCrossing;

    @Before
    public void setup() {
        pathCrossing = new PathCrossing();
    }

    @Test
    public void testcase1() {
        int[] nums = new int[] { 5, 4, 0, 3, 1, 6, 2 };
        Assert.assertEquals(false, pathCrossing.isPathCrossing("test"));
    }
}
