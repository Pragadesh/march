package org.pg.march.lc.coll;

/*
 * https://leetcode.com/problems/array-nesting/
 */
public class ArrayNesting {

	public int arrayNesting(int[] nums) {
		int max = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] < 0) continue;
			int count = 1;
			int next = nums[i];
			while(next != i) {
				count++;
				int curr = next;
				next = nums[next];
				nums[curr] = -1;
			}
			max = Math.max(max, count);
		}
		
		return max;
	}
}
