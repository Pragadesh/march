package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MissingNumberTest {

    private MissingNumber missingNumber;

    @Before
    public void setup() {
        missingNumber = new MissingNumber();
    }

    @Test
    public void testcase1() {
        int[] nums = { 3, 0, 1 };
        Assert.assertEquals(2, missingNumber.missingNumber(nums));
    }

    @Test
    public void testcase2() {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        Assert.assertEquals(8, missingNumber.missingNumber(nums));
    }
}
