package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaystoAddParentheses {

    public static final char ADD = '+';
    public static final char SUB = '-';
    public static final char MUL = '*';

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> computes = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ADD || ch == SUB || ch == MUL) {
                List<Integer> leftComputes = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightComputes = diffWaysToCompute(input.substring(i+1));
                
                for(Integer left : leftComputes) {
                    for(Integer right : rightComputes) {
                        switch (ch) {
                            case ADD:
                                computes.add(left + right);
                                break;
                            case SUB:
                                computes.add(left - right);
                                break;
                            case MUL:
                                computes.add(left * right);
                                break;
                            default:
                                break;
                        }
                    }
                }
                
            }
        }
        if(computes.isEmpty()) {
            computes.add(Integer.parseInt(input));
        }
        Collections.sort(computes);
        return computes;
    }
}
