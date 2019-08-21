package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MedianOfSortedArraysTest {

    private MedianOfSortedArrays medianOfSortedArrays;

    @Before
    public void setup() {
        medianOfSortedArrays = new MedianOfSortedArrays();
    }

    @Test
    public void testCase1() {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        Assert.assertEquals(2d, medianOfSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testCase2() {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        Assert.assertEquals(2.5d, medianOfSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
