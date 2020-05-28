package org.pg.march.lc.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2;) {
            int expected = nums[i] * -1;
            int left = i + 1;
            int right = len - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == expected) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while(left < len && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                }else if(sum > expected) {
                    right--;
                }else {
                    left++;
                }
            }
            i++;
            while(i < len - 2 && nums[i] == nums[i-1]) {
                i++;
            }
        }

        return result;
    }
}
 