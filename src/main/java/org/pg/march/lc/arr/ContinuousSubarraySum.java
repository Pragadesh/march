package org.pg.march.lc.arr;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class ContinuousSubarraySum {

	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> indexMap = new HashMap<>();
		indexMap.put(0, -1);
		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			sum %= k;
			Integer prev = indexMap.get(sum);
			if(prev != null) {
				if(i - prev > 1) return true;
			}else {
				indexMap.put(sum, i);
			}
			
			
		}
		return false;
	}
}
