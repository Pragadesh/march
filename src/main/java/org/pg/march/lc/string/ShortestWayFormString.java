package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/shortest-way-to-form-string/
 */
public class ShortestWayFormString {

    public int shortestWay(String source, String target) {
        List<Integer>[] traverseMap = createTraverseMap(source);
        return isSubSequence(target, traverseMap);
    }

    private int isSubSequence(String target, List<Integer>[] traverseMap) {
        int next = 0;
        int count = 1;
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (traverseMap[ch] == null)
                return -1;
            int j = Collections.binarySearch(traverseMap[ch], next);
            if (j < 0)
                j = -(j + 1);
            if (j == traverseMap[ch].size()) {
                count++;
                next = 0;
                i--;
            } else {
                next = traverseMap[ch].get(j) + 1;
            }
        }
        return count;
    }

    private List<Integer>[] createTraverseMap(String source) {
        List<Integer>[] traverseMap = (List<Integer>[]) new List[256];
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            if (traverseMap[ch] == null) {
                traverseMap[ch] = new ArrayList<>();
            }
            traverseMap[ch].add(i);
        }
        return traverseMap;
    }
}
