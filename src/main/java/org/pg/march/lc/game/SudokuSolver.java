package org.pg.march.lc.game;

import java.util.ArrayList;
import java.util.List;

import org.pg.march.lc.coll.IndexedPQ;
import org.pg.march.lc.coll.IndexedPQ.IndexedPQNode;

/*
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {

    private static final char ZERO = '0';
    private static final char EMPTY = '.';

    private int[] rowConstraints;
    private int[] columnConstraints;
    private int[] subGridConstraints;
    
    private static final int LENGTH = 9;
    
    public void solveSudoku(char[][] board) {
        initializeConstraints(board);
//        boolean result = fillBySequence(board, 0);
        boolean result = solveByPQ(board);
        System.out.println(String.format("Sudoku generated successfully: %b", result));
    }

    private boolean solveByPQ(char[][] board) {
        IndexedPQ<Integer> pq = new IndexedPQ<>(LENGTH * LENGTH);
        for (int row = 0; row < LENGTH; row++) {
            for (int col = 0; col < LENGTH; col++) {
                int n = board[row][col] - ZERO;
                if (n < 1 || n > 9) {
                    int possibleCount = getAllowedValues(row, col).size();
                    pq.add(row * LENGTH + col, possibleCount);
                }
            }
        }
        return fillByPQ(board, pq);
    }
    
    private boolean fillByPQ(char[][] board, IndexedPQ<Integer> pq) {
        if(pq.isEmpty()) return true;
        IndexedPQNode<Integer> node = pq.deleteMin();
        int row = node.index / LENGTH;
        int col = node.index % LENGTH;
        List<Integer> allowedValues = getAllowedValues(row, col);
        for(Integer allowedValue : allowedValues) {
            addConstrain(row, col, allowedValue);
            board[row][col] = (char) (ZERO + allowedValue);
            if (fillByPQ(board, pq)) {
                return true;
            } else {
                removeConstrain(row, col, allowedValue);
                board[row][col] = EMPTY;
            }
        }
        pq.add(node.index, node.value);
        return false;
    }
    
    private void reIndexPQ(char[][] board, IndexedPQ<Integer> pq, int row, int col) {
        int subGrid = getSubGridIndex(row, col);
        for(int i = 0; i<LENGTH;i++) {
            
        }
    }

    private boolean fillBySequence(char[][] board, int pos) {
        if (pos >= 81) {
            return true;
        }
        int row = pos / 9;
        int col = pos % 9;
        int val = board[row][col] - ZERO;
        if (val > 0 && val <= 9) {
            return fillBySequence(board, pos + 1);
        } else {
            List<Integer> possibleValues = getAllowedValues(row, col);
            for (Integer possible : possibleValues) {
                addConstrain(row, col, possible);
                board[row][col] = (char) (ZERO + possible);
                if (fillBySequence(board, pos + 1)) {
                    return true;
                } else {
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
                if (n >= 0 && n <= 9) {
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

    private List<Integer> getAllowedValues(int row, int col) {
        return getAllowedValues(rowConstraints[row] | columnConstraints[col] | subGridConstraints[getSubGridIndex(row, col)]);
    }

    private List<Integer> getAllowedValues(int constraint) {
        List<Integer> allowed = new ArrayList<>();
        int i = 0;
        while (++i < 10) {
            if ((constraint & 1) == 0) {
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
