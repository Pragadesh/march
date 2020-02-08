package org.pg.march.lc.dp;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BurstBalloonsTest {

    BurstBalloons burstBalloons;

    @Before
    public void setup() {
        burstBalloons = new BurstBalloons();
    }

    @Test
    public void testcase1() {
        int[] nums = { 3, 1, 5, 8 };
        Assert.assertEquals(167, burstBalloons.maxCoinsTopDown(nums));
    }
}
