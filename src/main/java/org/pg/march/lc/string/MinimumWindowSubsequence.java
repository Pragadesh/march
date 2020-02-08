package org.pg.march.lc.string;

/*
 * https://leetcode.com/problems/minimum-window-subsequence/
 */
public class MinimumWindowSubsequence {

	public String minWindow(String S, String T) {
		if (S == null || T == null || S.isEmpty()) {
			return "";
		}
		if (S.contains(T)) {
			return T;
		}
		char[] source = S.toCharArray();
		char[] match = T.toCharArray();
		char pivot = match[0];

		int sMatch = -1;
		int minLength = Integer.MAX_VALUE;
		for (int sIdx = 0; sIdx < source.length; sIdx++) {
			if (source[sIdx] == pivot) {
				int endIdx = matchSubString(source, match, sIdx + 1, 1);
				if(endIdx > sIdx && endIdx - sIdx < minLength) {
					sMatch = sIdx;
					minLength = endIdx - sIdx;
				}
			}
		}
		return sMatch == -1? "" : S.substring(sMatch, sMatch + minLength);
	}

	private int matchSubString(char[] source, char[] match, int sIdx, int mIdx) {
		while(mIdx < match.length && sIdx < source.length) {
			if(source[sIdx] == match[mIdx]) {
				mIdx++;
			}
			sIdx++;
		}
		return mIdx == match.length? sIdx : -1;
	}
}
