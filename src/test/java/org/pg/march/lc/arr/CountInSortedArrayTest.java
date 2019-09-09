package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CountInSortedArrayTest {

    
    
    CountInSortedArray countInSortedArray = new CountInSortedArray();

    @Before
    public void setup() {
        countInSortedArray = new CountInSortedArray();
    }

    @Test
    public void testCase1() {
        int[] nums = { 0, 1, 2, 2, 3 };
        Assert.assertEquals(2, countInSortedArray.numberOfOccurrences(nums, 2));
        Assert.assertEquals(1, countInSortedArray.numberOfOccurrences(nums, 0));
        Assert.assertEquals(1, countInSortedArray.numberOfOccurrences(nums, 1));
        Assert.assertEquals(1, countInSortedArray.numberOfOccurrences(nums, 3));
        Assert.assertEquals(0, countInSortedArray.numberOfOccurrences(nums, 4));
    }   
}
