package org.pg.march.lc.arr;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 */
public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] ssCnt = new int[nums.length];
        int[] ssLen = new int[nums.length];
        Arrays.fill(ssLen, 1);
        Arrays.fill(ssCnt, 1);
        int maxLen = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(ssLen[j] >= ssLen[i]) {
                        ssLen[i] = ssLen[j] + 1;
                        ssCnt[i] = ssCnt[j];
                    }else if(ssLen[i] == ssLen[j] + 1){
                        ssCnt[i] += ssCnt[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, ssLen[i]);
        }
        
        int totalCount = 0;
        for (int i = 0; i < ssLen.length; i++) {
            if(ssLen[i] == maxLen) {
                totalCount += ssCnt[i];
            }
        }
        return totalCount;
    }
}
