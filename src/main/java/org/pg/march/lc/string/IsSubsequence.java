package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        List<Integer>[] traverseMap = createTraverseMap(t);
        return isSubSequence(s, traverseMap);
    }

    private boolean isSubSequence(String s, List<Integer>[] traverseMap) {
        int next = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(traverseMap[ch] == null) return false;
            int j = Collections.binarySearch(traverseMap[ch], next);
            if (j < 0) j = -(j + 1);
            if(j == traverseMap[ch].size()) return false;
            next = traverseMap[ch].get(j) + 1;
        }
        return true;
    }

    private List<Integer>[] createTraverseMap(String t) {
        List<Integer>[] traverseMap = (List<Integer>[]) new List[256];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (traverseMap[ch] == null) {
                traverseMap[ch] = new ArrayList<>();
            }
            traverseMap[ch].add(i);
        }
        return traverseMap;
    }
}
