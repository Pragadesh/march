package org.pg.march.lc.graph;

/*
 * https://leetcode.com/contest/weekly-contest-157/problems/path-with-maximum-
 * gold/
 */
public class PathWithMaximumGold {

    private static final int[] directions = new int[] { 0, -1, 0, 1, 0 };

    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                max = Math.max(max, dfs(grid, row, col));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int row, int col) {
        int max = 0;
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] != 0) {
            int tmp = grid[row][col];
            grid[row][col] = 0;
            for (int i = 0; i < 4; i++) {
                int xx = row + directions[i];
                int yy = col + directions[i + 1];
                max = Math.max(max, tmp + dfs(grid, xx, yy));
            }
            grid[row][col] = tmp;
        }
        return max;
    }
}
