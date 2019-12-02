package org.pg.march.lc.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		return longestValidParenthesesByDP(s);
	}

	public int longestValidParenthesesByDP(String s) {
		int[] dp = new int[s.length()];
		int maxLen = 0;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
				}
				maxLen = Math.max(maxLen, dp[i]);
			}
		}

		return maxLen;
	}

	public int longestValidParenthesesByStack(String s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else if (c == ')') {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					maxLen = Math.max(maxLen, i - stack.peek());
				}
			} else {
				return 0;
			}
		}
		return maxLen;
	}

	public int longestValidParenthesesByWindow(String s) {
		Map<Integer, Integer> positionMap = new HashMap<>();
		positionMap.put(0, -1);
		int maxLen = 0;

		int runLegth = 0;
		boolean reset = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (runLegth == 0 && reset) {
				positionMap.clear();
				reset = false;
				positionMap.put(0, i - 1);
			}
			if (c == '(') {
				runLegth++;
				if (!positionMap.containsKey(runLegth)) {
					positionMap.put(runLegth, i);
				}
			} else if (c == ')' && runLegth > 0) {
				if (positionMap.containsKey(runLegth)) {
					maxLen = Math.max(maxLen, i - positionMap.get(runLegth) + 1);
				}
				runLegth--;
			} else if (c == ')') {
				reset = true;
			}
		}

		return maxLen;
	}
}
