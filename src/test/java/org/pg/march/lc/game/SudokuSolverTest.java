package org.pg.march.lc.game;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SudokuSolverTest {

	
    private SudokuSolver sudokuSolver;
    private SudokuValidity sudokuValidity;

    @Before
    public void setup() {
    	sudokuSolver = new SudokuSolver();
    	sudokuValidity = new SudokuValidity();
    }

    @Test
    public void testcase1() {
        char [][] board = {
        		  {'5','3','.','.','7','.','.','.','.'},
        		  {'6','.','.','1','9','5','.','.','.'},
        		  {'.','9','8','.','.','.','.','6','.'},
        		  {'8','.','.','.','6','.','.','.','3'},
        		  {'4','.','.','8','.','3','.','.','1'},
        		  {'7','.','.','.','2','.','.','.','6'},
        		  {'.','6','.','.','.','.','2','8','.'},
        		  {'.','.','.','4','1','9','.','.','5'},
        		  {'.','.','.','.','8','.','.','7','9'}
        		};
        sudokuSolver.solveSudoku(board);
        Assert.assertEquals(true, sudokuValidity.isFull(board));
        Assert.assertEquals(true, sudokuValidity.isValidSudoku(board));
    }
}
