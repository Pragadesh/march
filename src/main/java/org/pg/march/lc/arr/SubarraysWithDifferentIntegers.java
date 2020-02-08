package org.pg.march.lc.arr;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/subarrays-with-k-different-integers/
 */
public class SubarraysWithDifferentIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0, prefix = 0;
        int[] m = new int[A.length + 1];
        for (int i = 0, j = 0, cnt = 0; i < A.length; ++i) {
            if (m[A[i]]++ == 0)
                ++cnt;
            if (cnt > K) {
                --m[A[j++]];
                --cnt;
                prefix = 0;
            }
            while (m[A[j]] > 1) {
                ++prefix;
                --m[A[j++]];
            }
            if (cnt == K)
                res += prefix + 1;
        }
        return res;
    }
    
    public int subarraysWithKDistinctFirstTry(int[] A, int K) {
        int num = 0;
        int left = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if(increment(countMap, A[i]) == 1) {
                K--;
            }
            while (K <= 0) {
                if(K == 0) num++;
                if(decrement(countMap, A[left++]) == 0) {
                    K++;
                }
            }
        }
        return num;
    }
    
    private int increment(Map<Integer, Integer> countMap, int key) {
        int currValue = countMap.getOrDefault(key, 0);
        countMap.put(key, ++currValue);
        return currValue;
    }
    
    private int decrement(Map<Integer, Integer> countMap, int key) {
        Integer currValue = countMap.get(key);
        if(currValue != null) {
            if(--currValue > 0) {
                countMap.put(key, currValue);
                return currValue;
            }else {
                countMap.remove(key);
            }
        }
        return 0;
    }
}
