package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ShortestWayFormStringTest {

    private ShortestWayFormString shortestWayFormString;

    @Before
    public void setup() {
        shortestWayFormString = new ShortestWayFormString();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(2, shortestWayFormString.shortestWay("abc", "abcbc"));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(-1, shortestWayFormString.shortestWay("abc", "acdbc"));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(3, shortestWayFormString.shortestWay("xyz", "xzyxz"));
    }
    
}
