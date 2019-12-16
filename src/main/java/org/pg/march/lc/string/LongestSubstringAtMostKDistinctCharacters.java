package org.pg.march.lc.string;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 */
public class LongestSubstringAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        Map<Character, Integer> chaacterSizeMap = new HashMap<>();
        int max = 0;
        int left = 0;
        int distinctCharacter = 0;
        for (int i = 0; i < s.length(); i++) {
            char newChar = s.charAt(i);
            int noOfChars = chaacterSizeMap.getOrDefault(newChar, 0);
            if (noOfChars == 0) {
                distinctCharacter++;
            }
            chaacterSizeMap.put(newChar, noOfChars + 1);
            while (distinctCharacter > k) {
                char expiredChar = s.charAt(left++);
                int noOfExpiredChars = chaacterSizeMap.getOrDefault(expiredChar, 0);
                if (noOfExpiredChars > 0) {
                    chaacterSizeMap.put(expiredChar, --noOfExpiredChars);
                    if (noOfExpiredChars == 0) {
                        distinctCharacter--;
                    }
                }
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
