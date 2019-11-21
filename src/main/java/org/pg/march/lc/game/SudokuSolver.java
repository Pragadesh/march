package org.pg.march.lc.game;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {

    private static final char ZERO = '0';
    private static final char EMPTY = '.';

    private int[] rowConstraints;
    private int[] columnConstraints;
    private int[] subGridConstraints;

    public void solveSudoku(char[][] board) {
        initializeConstraints(board);
        boolean result = fill(board, 0);
        System.out.println(String.format("Sudoku generated successfully: %b", result));
    }
    
    private boolean fill(char[][] board, int pos) {
        if(pos >= 81) {
            return true;
        }
        int row = pos / 9;
        int col = pos % 9;
        int val = board[row][col] - ZERO;
        if(val > 0 && val <= 9) {
            return fill(board, pos + 1);
        }else {
            List<Integer> possibleValues = getAllowedValues(row, col);
            for(Integer possible : possibleValues) {
                addConstrain(row, col, possible);
                board[row][col] = (char) (ZERO + possible);
                if (fill(board, pos + 1)) {
                    return true;
                }else {
                    removeConstrain(row, col, possible);
                    board[row][col] = EMPTY;
                }
            }
            return false;
        }
    }

    private void initializeConstraints(char[][] board) {
        rowConstraints = new int[9];
        columnConstraints = new int[9];
        subGridConstraints = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int n = board[i][j] - ZERO;
                if(n >= 0 && n <= 9) {
                    addConstrain(i, j, n);
                }
            }
        }
    }
    
    private void addConstrain(int row, int col, int value) {
        int valByPos = 1 << (value - 1);
        rowConstraints[row] |= valByPos;
        columnConstraints[col] |= valByPos;
        subGridConstraints[getSubGridIndex(row, col)] |= valByPos;
    }
    
    private void removeConstrain(int row, int col, int value) {
        int valByPos = 1 << (value - 1);
        rowConstraints[row] ^= valByPos;
        columnConstraints[col] ^= valByPos;
        subGridConstraints[getSubGridIndex(row, col)] ^= valByPos;
    }
    
    private List<Integer> getAllowedValues(int row, int col){
        return getAllowedValues(rowConstraints[row] | columnConstraints[col] | subGridConstraints[getSubGridIndex(row, col)]);
    }
    
    private List<Integer> getAllowedValues(int constraint){
        List<Integer> allowed = new ArrayList<>();
        int i = 0;
        while(++i < 10) {
            if((constraint & 1) == 0) {
                allowed.add(i);
            }
            constraint >>>= 1;
        }
        return allowed;
    }

    private int getSubGridIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }
}
