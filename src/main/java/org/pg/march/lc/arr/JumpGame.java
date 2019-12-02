package org.pg.march.lc.arr;

/*
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

	public boolean canJump(int[] nums) {
		int target = nums.length - 1;
		int distance = -1;

		for (int i = 0; i < nums.length; i++) {
			distance = Math.max(distance - 1, nums[i]);
			if (i + distance >= target) {
				return true;
			} else if (distance == 0) {
				return false;
			}
		}
		return false;
	}

}
