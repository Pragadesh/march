package org.pg.march.lc.string;

/*
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int j = 2; j <= p.length(); j += 2) {
			if (p.charAt(j - 1) != '*') {
				break;
			} else {
				dp[0][j] = true;
			}
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				char pj = p.charAt(j - 1);
				if (pj == '.' || pj == s.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pj == '*') {
					char ppc = p.charAt(j - 2);
					if (ppc == '.' || ppc == s.charAt(i - 1)) {
						dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j-2];
					}else {
						dp[i][j] = dp[i][j-2];
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
