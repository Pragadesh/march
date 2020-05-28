package org.pg.march.lc.string;

/*
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemoveMakeValidParentheses {

	public String minRemoveToMakeValid(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		return validateString(s, 0, new char[] { '(', ')' });
	}

	private String validateString(String s, int index, char[] paranthesis) {
		int count = 0;
		for (int i = index; i < s.length(); i++) {
			if(s.charAt(i) == paranthesis[0]) {
				count++;
			}else if(s.charAt(i) == paranthesis[1]) {
				if(--count < 0) {
					return validateString(s.substring(0, i) + (i == s.length() - 1 ? "" : s.substring(i + 1)), index,
							paranthesis);
				}
			}
		}
		String reverse = new StringBuilder(s).reverse().toString();
		if(paranthesis[0] == '(') {
			return validateString(reverse, 0, new char[] { ')', '(' });
		}else {
			return reverse;
		}
	}
}
