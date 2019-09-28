package org.pg.march.lc.num;

/*
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return partition(nums, 0, nums.length - 1);
    }

    private int partition(int[] nums, int lo, int hi) {
        if (hi - lo < nums.length / 2) {
            return -1;
        }
        int i = lo;
        int j = hi;
        exch(nums, lo + (hi - lo) / 2, i);
        int pi = i;
        int k = nums[pi];
        while (pi <= j) {
            int val = Integer.compare(k, nums[pi]);
            if (val > 0) {
                exch(nums, pi++, i++);
            } else if (val < 0) {
                exch(nums, pi, j--);
            } else {
                pi++;
            }
        }
        if (pi - i > nums.length / 2) {
            return nums[i];
        }
        if (i - lo > hi - pi) {
            return partition(nums, lo, i - 1);
        }
        return partition(nums, pi, hi);
    }

    private void exch(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
