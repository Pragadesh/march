package org.pg.march.lc.num;

import java.util.Stack;

/*
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculator2 {

    public int calculate(String s) {

        int result = 0;
        int num = 0;
        char operator = '+';
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == len - 1) {
                if(operator == '+') {
                    stack.push(num);
                }else if(operator == '-') {
                    stack.push(-num);
                }else if(operator == '*') {
                    stack.push(stack.pop() * num);
                }else if(operator == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                operator = ch;
            }
        }
        for(int n : stack) {
            result += n;
        }
        return result;
    }
}
