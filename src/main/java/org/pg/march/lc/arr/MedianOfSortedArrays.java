package org.pg.march.lc.arr;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianPosition = (nums1.length + nums2.length - 1) / 2;
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int sIndex = -1;
        if(nums1.length > 0) {
            sIndex = findMedian(nums1, nums2, 0, nums1.length - 1, medianPosition);
        }
        return getMedian(nums1, nums2, sIndex, medianPosition);
    }

    private double getMedian(int[] sNums, int[] bNums, int sIndex, int medianPosition) {
        int bIndex = medianPosition - sIndex - 1;
        boolean twoMedians = (sNums.length + bNums.length) % 2 == 0;
        double median = 0d;
        if (bIndex < 0) {
            median = sNums[sIndex];
        } else if (sIndex < 0 || sNums[sIndex] < bNums[bIndex]) {
            median = bNums[bIndex];
        } else {
            median = sNums[sIndex];
        }
        if (twoMedians) {
            sIndex++;
            bIndex++;
            if (bIndex > bNums.length - 1) {
                median = (median + sNums[sIndex]) / 2;
            } else if (sIndex > sNums.length - 1) {
                median = (median + bNums[bIndex]) / 2;
            } else {
                median = (median + Math.min(sNums[sIndex], bNums[bIndex])) / 2;
            }

        }
        return median;
    }

    private int findMedian(int[] sNums, int[] bNums, int start, int end, int medianPosition) {
        if (start >= end) {
            return checkForMedian(sNums, bNums, start, medianPosition) == 0 ? start : -1;
        }
        int mid = (start + end) / 2;
        int posCompare = checkForMedian(sNums, bNums, mid, medianPosition);
        if (posCompare > 0) {
            return findMedian(sNums, bNums, mid + 1, end, medianPosition);
        } else if (posCompare < 0) {
            return findMedian(sNums, bNums, start, mid - 1, medianPosition);
        }
        return mid;
    }

    private int checkForMedian(int[] sNums, int[] bNums, int sIndex, int medianPosition) {
        int bIndex = medianPosition - sIndex;
        if (bIndex <= 0 || (sNums[sIndex] > bNums[bIndex - 1])) {
            return sNums[sIndex] > bNums[bIndex] ? -1 : 0;
        } else if (sNums[sIndex] < bNums[bIndex - 1]) {
            return (sIndex >= sNums.length - 1 || sNums[sIndex + 1] > bNums[bIndex - 1]) ? 0 : 1;
        }
        return 0;
    }

}
