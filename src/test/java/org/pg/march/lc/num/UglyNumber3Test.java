package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class UglyNumber3Test {

    private UglyNumber3 uglyNumber3;

    @Before
    public void setup() {
        uglyNumber3 = new UglyNumber3();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(4, uglyNumber3.nthUglyNumber(3, 2, 3, 5));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(6, uglyNumber3.nthUglyNumber(4, 2, 3, 4));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(10, uglyNumber3.nthUglyNumber(5, 2, 11, 13));
    }

    @Test
    public void testcase4() {
        Assert.assertEquals(1999999984, uglyNumber3.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }
}
