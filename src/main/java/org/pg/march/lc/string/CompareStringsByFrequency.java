package org.pg.march.lc.string;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-
 * character/
 */
public class CompareStringsByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] scores = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            scores[i] = score(words[i]);
        }
        Arrays.sort(scores);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = findHigherBound(scores, score(queries[i]));
        }
        return res;
    }

    private int findHigherBound(int[] scores, int value) {
        int lo = 0;
        int hi = scores.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] <= value) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return scores[lo] > value ? scores.length - lo : 0;
    }
    
    private int findLowerBound(int[] scores, int value) {
        int lo = 0;
        int hi = scores.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= value) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return scores[lo] < value ? lo + 1 : 0;
    }

    private int score(String word) {
        int score = 0;
        int pivot = word.codePointAt(0);
        for (int ch : word.toCharArray()) {
            if (ch < pivot) {
                pivot = ch;
                score = 1;
            } else if (ch == pivot) {
                score++;
            }
        }
        return score;
    }
}
