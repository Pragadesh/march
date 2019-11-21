package org.pg.march.lc.arr;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/contest/weekly-contest-158/problems/maximum-equal-frequency/
 */
public class MaximumEqualFrequency {

    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            int freq = countMap.get(nums[i]);
            freqMap.put(freq, freqMap.getOrDefault(freq, 0) + 1);
            int count = freqMap.get(freq);
            if(freq * count == i + 1 && i != nums.length - 1) {
                res = Math.max(res, i + 2);
            }else if(freq * count == i) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }
}
