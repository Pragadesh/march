package org.pg.march.lc.board;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NQueensTest {

	private NQueens nQueens;

	@Before
	public void setup() {
		nQueens = new NQueens();
	}

	@Test
	public void testcase1() {
		int n = 4;
		List<List<String>> boards = nQueens.solveNQueens(n);
		printBoards(boards, n);
	}
	
	@Test
	public void testcase2() {
		int n = 3;
		List<List<String>> boards = nQueens.solveNQueens(n);
		printBoards(boards, n);
	}
	
	private void printBoards(List<List<String>> boards, int n) {
		System.out.println(String.format("Found %d boards", boards.size()));
		StringBuilder builder = new StringBuilder();
		for (List<String> board : boards) {
			for (int cell = 0; cell < board.size(); cell++) {
				if(cell % n == 0)
					builder.append("\n");
				builder.append(board.get(cell)).append(" ");
			}
			builder.append("\n\n");
		}
		System.out.println(builder.toString());
	}
}
