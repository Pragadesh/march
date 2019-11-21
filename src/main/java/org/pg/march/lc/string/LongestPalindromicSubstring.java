package org.pg.march.lc.string;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		return longestPalindromeManachersAlgorithm(s);
	}
	
	
	
    /**
     * Linear time Manacher's algorithm to find longest palindromic substring.
     * There are 4 cases to handle
     * Case 1 : Right side palindrome is totally contained under current palindrome. In this case do not consider this as center.
     * Case 2 : Current palindrome is proper suffix of input. Terminate the loop in this case. No better palindrom will be found on right.
     * Case 3 : Right side palindrome is proper suffix and its corresponding left side palindrome is proper prefix of current palindrome. Make largest such point as
     * next center.
     * Case 4 : Right side palindrome is proper suffix but its left corresponding palindrome is be beyond current palindrome. Do not consider this
     * as center because it will not extend at all.
     *
     * To handle even size palindromes replace input string with one containing $ between every input character and in start and end.
     * 
     * Reference: https://github.com/mission-peace/interview/blob/master/src/com/interview/string/LongestPalindromeSubstring.java
     */
	
	public String longestPalindromeManachersAlgorithm(String s) {
		
		int N = s.length();
		char[] seq = new char[2 * N + 1];
		int k = 0;
		for (int i = 0; i < seq.length; i++) {
			if (i % 2 == 1) {
				seq[i] = s.charAt(k++);
			} else {
				seq[i] = '$';
			}
		}
		
		int[] seqLen = new int[seq.length];
		int i = 0;
		int maxI = 0;
		while ( i < seqLen.length) {
			seqLen[i] = findPalindromLength(seq, i, i);
			int halfLength = seqLen[i] / 2;
			int newCenter = i + halfLength + 1;
			if(seqLen[i] > seqLen[maxI]) {
				maxI = i;
			}
			if(i + halfLength >= seq.length) {
				break;
			}
			for (int j = 1; j < seqLen[i] / 2; j++) {
				int len = seqLen[i-j];
				if (j + len / 2 >= i + halfLength && (i - j) - len / 2 >= i - halfLength) {
					newCenter=j;
					break;
				}
			}
			i=newCenter;
			
		}
		int left = maxI - seqLen[maxI] / 2 + 1;
		StringBuilder builder = new StringBuilder();
		for(k = left; k<left + seqLen[maxI] -2; k+=2) {
			builder.append(seq[k]);
		}
		System.out.println(seq);
		System.out.println(Arrays.toString(seqLen));
		System.out.println(builder.toString());
		return builder.toString();
	}
	
	private int findPalindromLength(char[] s, int left, int right) { 
		while (left >= 0 && right < s.length && s[left] == s[right]) {
			left--;
			right++;
		}
		return (right - left - 1);
	}
	
	private int findPalindromLength(String s, int left, int right) { 
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return (right - left - 1);
	}
	
	public String longestPalindromeDP(String s) {
		
		int N = s.length();
		boolean[][] dp = new boolean[N][N];
		int maxLen = 0;
		int index = 0;

		for (int i = N - 1; i >= 0; i--) {
			for (int j = i; j < N; j++) {
				dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]));
				if (dp[i][j] && (j - i + 1) >= maxLen) {
					maxLen = j - i + 1;
					index = i;
				}
			}
		}
		return s.substring(index, index + maxLen);
	}
	
	public String longestPalindromeSimple(String s) {
		int maxLen = 1, middle = 0;
		for (int i = 1; i < s.length(); i++) {
			int len = findPalindromLength(s, i, i);
			len = Math.max(len, findPalindromLength(s, i - 1 , i));
			if(len > maxLen) {
				maxLen = len; middle = i;
			}
		}
		int left = middle - maxLen/ 2; 
		return s.substring(left, left + maxLen);
	}
}
