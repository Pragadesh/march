package org.pg.march.lc.game;

import java.util.Arrays;
import java.util.HashSet;

/*
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class MinimumDominoRotations {

    public int minDominoRotations(int[] A, int[] B) {

        int len = A.length;
        if (len == 0 || B.length != len)
            return -1;

        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];

        for (int i = 0; i < len; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i]) {
                same[A[i]]++;
            }
        }
        for (int i = 1; i <= 6; i++) {
            if (countA[i] + countB[i] - same[i] == len) {
                return len - Math.max(countA[i], countB[i]);
            }
        }
        return -1;
    }
    
    public int minDominoRotationsSoln2(int[] A, int[] B) {
        int n = A.length;
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); ++i) {
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); ++i) {
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;
    }
    
    public int minDominoRotationsSoln3(int[] A, int[] B) {
        HashSet<Integer> s = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int[] countA = new int[7], countB = new int[7];
        for (int i = 0; i < A.length; ++i) {
            s.retainAll(new HashSet<>(Arrays.asList(A[i], B[i])));
            countA[A[i]]++;
            countB[B[i]]++;
        }
        for (int i : s)
            return A.length - Math.max(countA[i], countB[i]);
        return -1;
    }
}
