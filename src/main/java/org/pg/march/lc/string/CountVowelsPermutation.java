package org.pg.march.lc.string;

/*
 * https://leetcode.com/contest/weekly-contest-157/problems/count-vowels-permutation/
 * 
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * 1 <= n <= 2 * 10^4
 */
public class CountVowelsPermutation {

    private static final int maxVal = (int) 1e9+7;  
    
    public int countVowelPermutation(int n) {
        
        int[][] fromEdges = new int[][] { { 1, 2, 4 }, { 0, 2 }, { 1, 3 }, { 2 }, { 2, 3 } };
        int[][] dp = new int[n+1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i][j] = calculateSum(dp[i-1], fromEdges[j]);
            }
        }
        return getColumnSum(dp[n]);
    }
    
    private int calculateSum(int[] col, int[] fromEdges) {
        int sum = 0;
        for (int fromEdge : fromEdges) {
            sum += col[fromEdge];
            sum %= maxVal;
        }
        return sum;
    }
    
    private int getColumnSum(int[] col) {
        int sum = 0;
        for (int i = 0; i < col.length; i++) {
            sum += col[i];
            sum %= maxVal;
        }
        return sum;
    }
}
