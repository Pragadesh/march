package org.pg.march.lc.string;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/contest/weekly-contest-159/problems/replace-the-substring-for-balanced-string/
 */
public class ReplaceStringForBalancedString {
    
    private static final char[] possibleChars = { 'Q', 'W', 'E', 'R' };
    
    public int balancedString(String s) {
        int[] count = new int[128];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count[s.charAt(i)]++;
        }
        int left = 0;
        int min = len;
        int allowedCount = len / 4;
        for (int i = 0; i < len; i++) {
            count[s.charAt(i)]--;
            while(left < len && count['Q'] <= allowedCount && count['W'] <= allowedCount && count['E'] <= allowedCount && count['R'] <= allowedCount) {
                min = Math.min(min, i - left + 1);
                count[s.charAt(left++)]++;
            }
        }
        return min;
        
    }
    
    public int balancedStringFirstTry(String s) {
        int len;
        if(s == null || (len = s.length()) == 0 || len % 4 != 0) {
            return 0;
        }
        char[] cArr = s.toCharArray();
        Map<Character, Integer> extraMap = getExtraCharacterCountMap(cArr);
        int toMatchSize = extraMap.size();
        if(toMatchSize == 0) return 0;
        Map<Character, Integer> counterMap = new HashMap<>();
        int left = 0;
        int min = len;
        
        int actualMatchSize = 0;
        for (int i = 0; i < len; i++) {
            char c = cArr[i];
            if(extraMap.containsKey(c)) {
                int toMatchCount = extraMap.get(c);
                int actualCount = counterMap.getOrDefault(c, 0) + 1;
                counterMap.put(c, actualCount);
                if(toMatchCount == actualCount) {
                    actualMatchSize++;
                }
            }
            while(actualMatchSize >= toMatchSize && left <= i) {
                min = Math.min(min, (i - left + 1));
                char r = cArr[left++];
                if(extraMap.containsKey(r)) {
                    int toMatchCount = extraMap.get(r);
                    int actualCount = counterMap.getOrDefault(r, 1) - 1;
                    counterMap.put(r, actualCount);
                    if(toMatchCount > actualCount) {
                        actualMatchSize--;
                    }
                }
            }
        }
        return min;
    }

    private Map<Character, Integer> getExtraCharacterCountMap(char[] cArr) {
        Map<Character, Integer> counterMap = new HashMap<>();

        for (char c : cArr) {
            counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);
        }
        int total = 0;
        for (int count : counterMap.values()) {
            total += count;
        }
        int countPerCharacter = total / 4;
        for (char c : possibleChars) {
            Integer currCount = counterMap.remove(c);
            if (currCount != null && currCount > countPerCharacter) {
                counterMap.put(c, (currCount - countPerCharacter));
            }
        }
        return counterMap;
    }
    
}
