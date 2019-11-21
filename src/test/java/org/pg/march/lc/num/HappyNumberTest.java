package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class HappyNumberTest {

    private HappyNumber happyNumber;

    @Before
    public void setup() {
        happyNumber = new HappyNumber();
    }

    @Test
    public void testcase1() {
//        Assert.assertEquals(true, happyNumber.isHappy(19));
        Assert.assertEquals(true, happyNumber.isHappy(20));
    }
}
