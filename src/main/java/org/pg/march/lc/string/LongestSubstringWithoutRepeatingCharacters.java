package org.pg.march.lc.string;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int[] count = new int[256];
        int max = 0;

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            while (count[index] > 0) {
                count[s.charAt(left++)]--;
            }
            count[index]++;
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
