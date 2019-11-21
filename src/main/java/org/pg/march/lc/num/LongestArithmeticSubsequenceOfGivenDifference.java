package org.pg.march.lc.num;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/contest/weekly-contest-157/problems/longest-arithmetic-
 * subsequence-of-given-difference/
 */
public class LongestArithmeticSubsequenceOfGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> sequenceMap = new HashMap<>();
        int maxDiff = 0;
        for (int i = 0; i < arr.length; i++) {
            int pos = sequenceMap.getOrDefault(arr[i] - difference, 0);
            sequenceMap.put(arr[i], pos + 1);
            maxDiff = Math.max(maxDiff, 1 + pos);
        }
        return maxDiff;
    }
}
