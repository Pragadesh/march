package org.pg.march.lc.string;

/*
 * https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3.length() != s1.length() + s2.length())
	        return false;
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
				} else {
					int k = i + j - 1;
					dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k))
							|| (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k));
				}
			}
		}

		return dp[s1.length()][s2.length()];
	}

	private boolean _isInterleaveRecursion(String s1, int i1, String s2, int i2, String s3, int i3) {
		if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length()) {
			return true;
		}
		if (i1 > s1.length() || i2 > s2.length() || i3 >= s3.length()) {
			return false;
		}
		char match = s3.charAt(i3);
		boolean first = i1 < s1.length() && s1.charAt(i1) == match;
		boolean second = i2 < s2.length() && s2.charAt(i2) == match;
		if (first && second) {
			return _isInterleaveRecursion(s1, i1 + 1, s2, i2, s3, i3 + 1)
					|| _isInterleaveRecursion(s1, i1, s2, i2 + 1, s3, i3 + 1);
		} else if (first) {
			return _isInterleaveRecursion(s1, i1 + 1, s2, i2, s3, i3 + 1);
		} else if (second) {
			return _isInterleaveRecursion(s1, i1, s2, i2 + 1, s3, i3 + 1);
		}
		return false;
	}
}
