package org.pg.march.lc.arr;

public class CountInSortedArray {

    public int numberOfOccurrences(int[] nums, int key) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = getBoundaryPoint(nums, 0, nums.length - 1, key, false);
        if (start < nums.length && nums[start] == key) {
            if (start == nums.length - 1) {
                return 1;
            }
            int end = getBoundaryPoint(nums, start, nums.length - 1, key, true);
            return (end - start + 1);
        }
        return 0;
    }

    private int getBoundaryPoint(int[] nums, int start, int end, int key, boolean forwardDirection) {
        int lo = start;
        int hi = end;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < key) {
                lo = mid + 1;
            } else if (nums[mid] > key) {
                hi = mid - 1;
            } else {
                if (lo == hi)
                    return lo;
                if (forwardDirection && lo != mid) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        return lo;
    }
}
