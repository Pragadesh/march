package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CouplesHoldingHandTest {

    CouplesHoldingHand couplesHoldingHand = new CouplesHoldingHand();

    @Before
    public void setup() {
        couplesHoldingHand = new CouplesHoldingHand();
    }

    @Test
    public void testcase1() {
        int[] row = new int[] { 0, 2, 1, 3 };
        Assert.assertEquals(1, couplesHoldingHand.minSwapsCouples(row));
    }

    @Test
    public void testcase2() {
        int[] row = new int[] { 3, 2, 0, 1 };
        Assert.assertEquals(0, couplesHoldingHand.minSwapsCouples(row));
    }
    
    @Test
    public void testcase3() {
        int[] row = new int[] { 0, 2, 3, 4, 5, 1 };
        Assert.assertEquals(1, couplesHoldingHand.minSwapsCouples(row));
    }
    
    @Test
    public void testcase4() {
        int[] row = new int[] { 0, 1, 2, 3, 4, 5 };
        Assert.assertEquals(1, couplesHoldingHand.minSwapsCouples(row));
    }
    
    @Test
    public void testcase5() {
        int[] row = new int[] { 0, 2, 3, 4, 5, 6, 7, 8, 9, 1 };
        Assert.assertEquals(1, couplesHoldingHand.minSwapsCouples(row));
    }
}
