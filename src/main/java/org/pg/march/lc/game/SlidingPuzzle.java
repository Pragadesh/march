package org.pg.march.lc.game;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/sliding-puzzle/
 */
public class SlidingPuzzle {

    private static final char ZERO = '0';
    private static final int[][] dirs = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

    public int slidingPuzzle(int[][] board) {

        String target = "123450";
        String start = "";

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                start += board[row][col];
            }
        }
        if(target.equals(start)) return 0;
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        seen.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int zeroPos = curr.indexOf(ZERO);
                for (int dir : dirs[zeroPos]) {
                    String newBoard = swap(curr, zeroPos, dir);
                    if(target.equalsIgnoreCase(newBoard)) {
                        return res + 1;
                    }
                    if(!seen.contains(newBoard)) {
                        seen.add(newBoard);
                        queue.offer(newBoard);
                    }
                }
            }
            res++;
        }

        return -1;
    }

    private String swap(String status, int pos1, int pos2) {
        StringBuilder builder = new StringBuilder(status);
        builder.setCharAt(pos1, status.charAt(pos2));
        builder.setCharAt(pos2, status.charAt(pos1));
        return builder.toString();
    }

}
