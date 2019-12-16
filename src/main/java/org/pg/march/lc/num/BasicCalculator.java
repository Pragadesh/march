package org.pg.march.lc.num;

import java.util.Stack;

/*
 * https://leetcode.com/problems/basic-calculator/
 */
public class BasicCalculator {

	public int calculate(String s) {
		int result = 0;
		int number = 0;
		int sign = 1;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				number = (number * 10) + (ch - '0');
			}else if(ch == '+') {
				result += (sign * number);
				number = 0;
				sign = 1;
			}else if(ch == '-') {
				result += (sign * number);
				number = 0;
				sign = -1;
			}else if(ch == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			}else if(ch == ')') {
				result += (sign * number);
				number = 0;
				result *= stack.pop();
				result += stack.pop();
			}
		}
		return result + (sign * number);
	}
}
