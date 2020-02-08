package org.pg.march.lc.num;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/confusing-number-ii/
 */
public class ConfusingNumber2 {

    private int count = 0;
    private int N;
    private int[][] inverse;

    public int confusingNumberII(int N) {
        createInverseList();
        this.N = N;
        for (int i = 1; i < inverse.length; i++) {
            generateConfuseNumber(inverse[i][0], inverse[i][1], 10);
        }
        return count;
    }

    private void generateConfuseNumber(int num, int rotated, int digit) {
        if (num > N)
            return;
        if (num != rotated)
            count++;
        for (int i = 0; i < inverse.length; i++) {
            generateConfuseNumber(num * 10 + inverse[i][0], inverse[i][1] * digit + rotated, digit * 10);
        }
    }

    private int[][] createInverseList() {
        inverse = new int[5][2];
        inverse[0] = new int[] { 0, 0 };
        inverse[1] = new int[] { 1, 1 };
        inverse[2] = new int[] { 6, 9 };
        inverse[3] = new int[] { 8, 8 };
        inverse[4] = new int[] { 9, 6 };
        return inverse;
    }

    public int confusingNumberIIQueue(int N) {

        List<String> validNumbers = Arrays.asList("0", "1", "6", "8", "9");
        int[] inverseMatch = createInverseMatch();
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        for (String num : validNumbers) {
            queue.add(num);
        }
        queue.poll();
        while (!queue.isEmpty()) {
            String num = queue.poll();
            if (Integer.parseInt(num) <= N) {
                if (!isMirrorPalindrome(num, inverseMatch)) {
                    count++;
                }
                for (String validNum : validNumbers) {
                    queue.add(num + validNum);
                }
            }
        }
        return count;
    }

    private int[] createInverseMatch() {
        int[] inverseMatch = new int[10];
        Arrays.fill(inverseMatch, -1);
        inverseMatch[0] = 0;
        inverseMatch[1] = 1;
        inverseMatch[6] = 9;
        inverseMatch[8] = 8;
        inverseMatch[9] = 6;
        return inverseMatch;
    }

    private boolean isMirrorPalindrome(String s, int[] inverseMatch) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (inverseMatch[s.charAt(l++) - '0'] != s.charAt(r--) - '0') {
                return false;
            }
        }
        return true;
    }
}
