package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SubarraysWithDifferentIntegersTest {

    private SubarraysWithDifferentIntegers subarraysWithDifferentIntegers;

    @Before
    public void setup() {
        subarraysWithDifferentIntegers = new SubarraysWithDifferentIntegers();
    }

    @Test
    public void testcase1() {
        int[] A = { 1, 2, 1, 2, 3 };
        Assert.assertEquals(7, subarraysWithDifferentIntegers.subarraysWithKDistinct(A, 2));
    }

    @Test
    public void testcase2() {
        int[] A = { 1, 2, 1, 3, 4 };
        Assert.assertEquals(3, subarraysWithDifferentIntegers.subarraysWithKDistinct(A, 3));
    }
}
