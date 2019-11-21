package org.pg.march.lc.arr;

/*
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums != null && nums.length > 0) {
            Integer second = null;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] <= nums[0]) {
                    nums[0] = nums[i];
                }else if(second == null || nums[i] <= second) {
                    second = nums[i];
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
