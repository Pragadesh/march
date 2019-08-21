package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class FindDuplicateNumberTest {
    private FindDuplicateNumber firstDuplicateNumber;

    @Before
    public void setup() {
        firstDuplicateNumber = new FindDuplicateNumber();
    }

    @Test
    public void testCase1() {
        int[] nums = { 1, 3, 4, 2, 2 };
        Assert.assertEquals(2, firstDuplicateNumber.findDuplicate(nums));
    }

    @Test
    public void testCase2() {
        int[] nums = { 3, 1, 3, 4, 2 };
        Assert.assertEquals(3, firstDuplicateNumber.findDuplicate(nums));
    }
    
    @Test
    public void testCase3() {
        int[] nums = { 1, 2, 3, 1, 4 };
        Assert.assertEquals(1, firstDuplicateNumber.findDuplicate(nums));
    }
}
