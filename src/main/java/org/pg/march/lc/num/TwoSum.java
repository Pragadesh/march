package org.pg.march.lc.num;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null)
            throw new IllegalArgumentException();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int[] { indexMap.get(target - nums[i]), i };
            }
            indexMap.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
