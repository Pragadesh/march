package org.pg.march.lc.game;

/*
 * https://leetcode.com/contest/weekly-contest-158/problems/dice-roll-
 * simulation/
 */
public class DiceRollSimulation {

    private static final int LIMIT = (int) 1e9 + 7;

    public int dieSimulator(int n, int[] rollMax) {

        int[][] seq = new int[n + 1][7];
        for (int i = 0; i < 6; i++) {
            seq[1][i] = 1;
        }
        seq[0][6] = 1;
        seq[1][6] = 6;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < 6; j++) {
                seq[i][j] = seq[i - 1][6];
                if (i > rollMax[j]) {
                    int diff = (seq[i - rollMax[j] - 1][6] - seq[i - rollMax[j] - 1][j]);
                    if (diff < 0)
                        diff += LIMIT;
                    seq[i][j] -= diff;
                    if (seq[i][j] < 0)
                        seq[i][j] += LIMIT;
                }
                sum += seq[i][j];
                sum %= LIMIT;
            }
            seq[i][6] = sum;
        }
        return seq[n][6];
    }

}
