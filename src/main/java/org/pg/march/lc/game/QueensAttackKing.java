package org.pg.march.lc.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/contest/weekly-contest-158/problems/queens-that-can-attack-the-king/
 */
public class QueensAttackKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> expectedList = new ArrayList<>();
        int boardSize = 8;
        boolean[][] seen = new boolean[boardSize][boardSize];
        for(int[] queen : queens) {
            seen[queen[0]][queen[1]] = true;
        }
        
        int[] dirs = { -1, 0, 1 };
        for(int dx : dirs) {
            for(int dy : dirs) {
                if(dx == 0 && dy == 0) continue;
                int x = king[0], y = king[1];
                while (x + dx >= 0 && x + dx < boardSize && y + dy >= 0 && y + dy < boardSize) {
                    x = x + dx;
                    y = y + dy;
                    if (seen[x][y]) {
                        expectedList.add(Arrays.asList(x, y));
                        break;
                    }
                }
            }
        }
        return expectedList;
    }
    
    public List<List<Integer>> queensAttacktheKingFirstSoln(int[][] queens, int[] king) {
        List<List<Integer>> expectedList = new ArrayList<>();
        int boardSize = 8;
        int[] attacks = new int[boardSize];
        for (int i = 0; i < boardSize; i++) {
            attacks[i] = boardSize;
        }
        
        for (int[] queen : queens) {
            if (queen[0] == king[0]) { // same row
                if (queen[1] < king[1]) {
                    attacks[0] = Math.min(attacks[0], king[1] - queen[1]);
                } else if (queen[1] > king[1]) {
                    attacks[2] = Math.min(attacks[2], queen[1] - king[1]);
                }
            } else if (queen[1] == king[1]) {
                if (queen[0] < king[0]) {
                    attacks[1] = Math.min(attacks[1], king[0] - queen[0]);
                } else if (queen[0] > king[0]) {
                    attacks[3] = Math.min(attacks[3], queen[0] - king[0]);
                }
            } else if (Math.abs(queen[0] - king[0]) == Math.abs(queen[1] - king[1])) {
                int distance = Math.abs(queen[0] - king[0]);
                if (queen[0] < king[0] && queen[1] < king[1]) {
                    attacks[4] = Math.min(attacks[4], distance);
                } else if (queen[0] < king[0] && queen[1] > king[1]) {
                    attacks[5] = Math.min(attacks[5], distance);
                } else if (queen[0] > king[0] && queen[1] < king[1]) {
                    attacks[6] = Math.min(attacks[6], distance);
                } else if (queen[0] > king[0] && queen[1] > king[1]) {
                    attacks[7] = Math.min(attacks[7], distance);
                }
            }
        }
        for (int i = 0; i < attacks.length; i++) {
            if(attacks[i] == boardSize) {
                continue;
            }
            if(i==0) {
                addPosition(expectedList, king[0], king[1] - attacks[i]);
            }else if (i == 2) {
                addPosition(expectedList, king[0], king[1] + attacks[i]);
            }else if (i == 1) {
                addPosition(expectedList, king[0] - attacks[i], king[1]);
            }else if(i == 3) {
                addPosition(expectedList, king[0] + attacks[i], king[1]);
            }else if(i == 4) {
                addPosition(expectedList, king[0] - attacks[i], king[1] - attacks[i]);
            }else if(i == 5) {
                addPosition(expectedList, king[0] - attacks[i], king[1] + attacks[i]);
            }else if(i == 6) {
                addPosition(expectedList, king[0] + attacks[i], king[1] - attacks[i]);
            }else if(i == 7) {
                addPosition(expectedList, king[0] + attacks[i], king[1] + attacks[i]);
            }
        }
        
        return expectedList;
    }
    
    private void addPosition(List<List<Integer>> expectedList, int x, int y) {
        List<Integer> pos = new ArrayList<>();
        pos.add(x);
        pos.add(y);
        expectedList.add(pos);
    }
    
}
