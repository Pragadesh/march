package org.pg.march.lc.arr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-out-of-three/
 */
public class TwoOutOfThree {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> counter = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        process(nums1, 1, counter, result);
        process(nums2, 2, counter, result);
        process(nums3, 3, counter, result);
        return new ArrayList<>(result);
    }

    protected void process(int[] nums, int index, Map<Integer, Integer> counter, Set<Integer> result) {
        for (int n : nums) {
            if (counter.containsKey(n)) {
                if (counter.get(n) != index) {
                    result.add(n);
                }
            } else {
                counter.put(n, index);
            }
        }
    }
}
