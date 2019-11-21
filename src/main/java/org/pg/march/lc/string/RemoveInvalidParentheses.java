package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {

    private static final char[] parantheses = new char[] { '(', ')' };
    private static final char[] reverseParantheses = new char[] { ')', '(' };

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        _removeInvalidParentheses(s, result, 0, 0, parantheses);
        return result;
    }

    private void _removeInvalidParentheses(String s, List<String> result, int iStart, int jStart, char[] pair) {
        for (int stack = 0, i = iStart; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == pair[0]) {
                stack++;
            }else if(c == pair[1]) {
                stack--;
            }
            if(stack >= 0) continue;
            for (int j = jStart; j <= i; j++) {
                if(s.charAt(j) == pair[1] && (j == jStart || s.charAt(j-1) != pair[1])) {
                    _removeInvalidParentheses(s.substring(0, j) + s.substring(j + 1), result, i, j, pair);
                }
            }
            return;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if(pair[0] == '(') {
            _removeInvalidParentheses(reverse, result, 0, 0, reverseParantheses);
        }else {
            result.add(reverse);
        }
    }
}
