package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/word-search-ii/
 */
public class Wordearch2 {

	private int R;
	private int C;
	private static final char SEEN = '$';
	private static final char a = 'a';

	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for(String word : words) {
			trie.addWord(word);
		}
		List<String> matches = new ArrayList<>();
		R = board.length;
		C = board[0].length;
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				dfs(board, row, col, trie.root, matches);
			}
		}
		return matches;
	}

	private void dfs(char[][] board, int row, int col, TrieNode node, List<String> matches) {
		if (row < 0 || col < 0 || row >= R || col >= C || board[row][col] == SEEN || node.next[board[row][col] - a] == null) {
			return;
		}
		char currChar = board[row][col];
		TrieNode newNode = node.next[currChar - a];
		if (newNode.word != null) {
			matches.add(newNode.word);
			newNode.word = null;
		}
		board[row][col] = SEEN;
		dfs(board, row - 1, col, newNode, matches);
		dfs(board, row + 1, col, newNode, matches);
		dfs(board, row, col - 1, newNode, matches);
		dfs(board, row, col + 1, newNode, matches);
		board[row][col] = currChar;
	}
	
	private static class Trie {
		private TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void addWord(String word) {
			TrieNode p = root;
			for(char c : word.toCharArray()) {
				int i = c - a;
				if(p.next[i] == null) {
					p.next[i] = new TrieNode();
				}
				p = p.next[i];
			}
			p.word = word;
		}
	}
	
	private static class TrieNode{
		
		public TrieNode() {
			this.next = new TrieNode[26];
		}
		private String word;
		private TrieNode[] next;
	}
}
