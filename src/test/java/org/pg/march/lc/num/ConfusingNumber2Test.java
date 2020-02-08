package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ConfusingNumber2Test {

    private ConfusingNumber2 ConfusingNumber2;

    @Before
    public void setup() {
        ConfusingNumber2 = new ConfusingNumber2();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(6, ConfusingNumber2.confusingNumberII(20));
    }
    
    @Test
    public void testcase2() {
        Assert.assertEquals(19, ConfusingNumber2.confusingNumberII(100));
    }
}
