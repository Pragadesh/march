package org.pg.march.lc.string;

/*
 * https://leetcode.com/contest/weekly-contest-158/problems/split-a-string-in-
 * balanced-strings/
 */
public class SplitBalancedStrings {

    public int balancedStringSplit(String s) {

        int mark = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'L') {
                mark--;
            }else if(c == 'R') {
                mark++;
            }
            if(mark == 0) {
                count++;
            }
        }
        return count;
    }
}
