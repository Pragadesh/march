package org.pg.march.lc.game;

public class SudokuValidity {

    private static final int ROW = 1 << 2;
    private static final int COLUMN = 1 << 1;
    private static final int SUB_BOX = 1;
    private static final int SUB_BOX_LENGTH = 3;
    private static final int VALID_LENGTH = 9;
    
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != VALID_LENGTH) {
            return false;
        }
        int[][] state = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            if (board[i] == null || board[i].length != VALID_LENGTH) {
                return false;
            }
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                if (ch >= 49 && ch <= 57) {
                    int val = (int) ch - 49;
                    try {
                        validateCell(board, state, i, j, val);
                    } catch (IllegalStateException e) {
                        return false;
                    }
                } else if (ch == 46) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private void validateCell(char[][] board, int[][] state, int row, int column, int val) {
        validateCellPosition(state, row, ROW, val);
        validateCellPosition(state, column, COLUMN, val);
        int subBox = SUB_BOX_LENGTH * (row / SUB_BOX_LENGTH) + (column / SUB_BOX_LENGTH);
        validateCellPosition(state, subBox, SUB_BOX, val);
    }

    private void validateCellPosition(int[][] state, int stateRow, int statePosition, int val) {
        int stateElement = state[stateRow][val];
        if((stateElement & statePosition) > 0) {
            throw new IllegalStateException();
        }
        state[stateRow][val] = stateElement | statePosition;
    }
}
