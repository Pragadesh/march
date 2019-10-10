package org.pg.march.lc.string;

/*
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] presentCount = new int[256];
        int expLength = t.length();
        for (int i = 0; i < expLength; i++) {
            presentCount[t.charAt(i)]++;
        }
        int[] occurenceCount = new int[256];
        int matchLength = 0;
        int startPos = 0;
        String match = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (matchLength < expLength && presentCount[c] > 0) {
                if (occurenceCount[c] < presentCount[c]) {
                    matchLength++;
                }
                occurenceCount[c]++;
            }
            while (matchLength >= expLength) {
                if (match == null || match.length() > (i - startPos + 1)) {
                    match = s.substring(startPos, i + 1);
                }
                c = s.charAt(startPos);
                if (presentCount[c] > 0) {
                    if (occurenceCount[c] <= presentCount[c]) {
                        matchLength--;
                    }
                    occurenceCount[c]--;
                }
                startPos++;
            }
        }
        return match == null? "" : match;
    }
}
