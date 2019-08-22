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
    
    @Test
    public void testCase3() {
        int[] nums1 = { 3, 4 };
        int[] nums2 = { 1, 2 };
        Assert.assertEquals(2.5d, medianOfSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testCase4() {
        int[] nums1 = { 1 };
        int[] nums2 = {};
        Assert.assertEquals(1d, medianOfSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
    
    @Test
    public void testCase5() {
        int[] nums1 = { 1,2 };
        int[] nums2 = {-1,3};
        Assert.assertEquals(1.5d, medianOfSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
    
    @Test
    public void testCase6() {
        int[] nums1 = { 1,2 };
        int[] nums2 = {1,1};
        Assert.assertEquals(1d, medianOfSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
