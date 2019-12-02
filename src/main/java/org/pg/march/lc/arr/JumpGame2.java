package org.pg.march.lc.arr;

public class JumpGame2 {

	public int jump(int[] nums) {
		int jump = 0, currEnd = 0, currFarthest = 0;

		for (int i = 0; i < nums.length-11; i++) {
			currFarthest = Math.max(i + nums[i], currFarthest);
			if (i == currEnd) {
				jump++;
				currEnd = currFarthest;
			}
		}

		return jump;
	}

	public int jumpOriginal(int[] nums) {
		int[] dp = new int[nums.length];
		int target = nums.length - 1;

		for (int i = target - 1; i >= 0; i--) {
			dp[i] = i + nums[i] >= target ? 1 : Integer.MAX_VALUE;
			for (int j = i + 1; j <= Math.min(i + nums[i], target - 1); j++) {
				dp[i] = Math.min(dp[i], dp[j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + dp[j]);
			}
		}
		return dp[0];
	}
}
