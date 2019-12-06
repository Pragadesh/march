package org.pg.march.lc.string;

/*
 * https://leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[s.length()][p.length()] = true;
		for (int i = p.length() - 1; i >= 0; i--) {
			if (p.charAt(i) != '*')
				break;
			else
				match[s.length()][i] = true;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = p.length() - 1; j >= 0; j--) {
				if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
					match[i][j] = match[i + 1][j + 1];
				else if (p.charAt(j) == '*')
					match[i][j] = match[i + 1][j] || match[i][j + 1];
				else
					match[i][j] = false;
			}
		}
		return match[0][0];
	}

	public boolean isMatchForwardDP(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		if(s.isEmpty() && p.isEmpty()) {
			return true;
		}
		if(p.isEmpty()) {
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int j = 1; j <= p.length(); j++) {
			if(p.charAt(j - 1) != '*') {
				break;
			}else {
				dp[0][j] = true;
			}
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				char pj = p.charAt(j - 1);
				if (pj == '?' || pj == s.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pj == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
