package org.pg.march.lc.game;

/*
 * https://leetcode.com/problems/design-tic-tac-toe/
 */
public class TicTacToe {

    private char[][] board;
    private StringBuilder[] rows;
    private StringBuilder[] cols;
    private StringBuilder upDiag;
    private StringBuilder downDiag;
    private int N;

    private static final char[] card = { 'X', '0' };
    private static final String[] winStatus = new String[2];
    // private static final char

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.N = n;
        board = new char[n][n];
        rows = new StringBuilder[N];
        cols = new StringBuilder[N];
        
        StringBuilder build = new StringBuilder(N);
        for (int i = 0; i < N; i++) {
            build.append('.');
        }
        String START = build.toString();
        upDiag = new StringBuilder(START);
        downDiag = new StringBuilder(START);
        for (int i = 0; i < N; i++) {
            rows[i] = new StringBuilder(START);
            cols[i] = new StringBuilder(START);
        }
        winStatus[0] = START.replaceAll(".", String.valueOf(card[0]));
        winStatus[1] = START.replaceAll(".", String.valueOf(card[1]));
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     * 
     * @param row The row of the board.
     * @param col The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either: 0: No one wins. 1:
     *         Player 1 wins. 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        if (row < 0 || col < 0 || col >= N || row >= N || player <= 0 || player > 2 || board[row][col] != Character.MIN_VALUE)
            return -1;
        board[row][col] = card[player - 1];
        String playerWin = winStatus[player - 1]; 
        rows[row].setCharAt(col, card[player - 1]);
        cols[col].setCharAt(row, card[player - 1]);
        if(row == col) {
            downDiag.setCharAt(row, card[player - 1]);
            if(downDiag.toString().equals(playerWin)) return player;
        }
        if(row + col == N - 1) {
            upDiag.setCharAt(row, card[player - 1]);
            if(upDiag.toString().equals(playerWin)) return player;
        }
        return rows[row].toString().equals(playerWin) || cols[col].toString().equals(playerWin)? player : 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such: TicTacToe obj
 * = new TicTacToe(n); int param_1 = obj.move(row,col,player);
 */