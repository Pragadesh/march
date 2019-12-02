package org.pg.march.lc.string;

/*
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {

	public int minDistance(String word1, String word2) {
		int N = word1.length();
		int M = word2.length();
		int[] dp = new int[M + 1];
		for (int j = 1; j <= M; j++) {
			dp[j] = j;
		}
		for (int i = 1; i <= N; i++) {
			int pre = dp[0];
			dp[0] = i;
			for (int j = 1; j <= M; j++) {
				int temp = dp[j];
				int delOp = dp[j - 1] + 1;
				int addOp = dp[j] + 1;
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					pre++;
				}
				dp[j] = Math.min(pre, Math.min(addOp, delOp));
				pre = temp;
			}
		}

		return dp[M];
	}
}
