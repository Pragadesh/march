package org.pg.march.lc.arr;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {

		Map<Integer, Integer> counter = new HashMap<>();
		counter.put(0, 1);
		int sum = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			res += counter.getOrDefault(sum - k, 0);
			counter.put(sum, counter.getOrDefault(sum, 0) + 1);
		}
		return res;
	}
}
