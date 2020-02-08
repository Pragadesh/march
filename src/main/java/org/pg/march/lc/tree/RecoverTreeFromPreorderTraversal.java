package org.pg.march.lc.tree;

import org.pg.march.lc.coll.TreeNode;

/*
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 */
public class RecoverTreeFromPreorderTraversal {

	private int position;
	
	public TreeNode recoverFromPreorder(String S) {
		return constructTree(S.toCharArray(), 0, S.length());
	}
	
	private TreeNode constructTree(char[] chArr, int depth, int maxLen) {
		Token token = constructToken(chArr, position, maxLen);
		if(token == null || token.depth != depth) {
			return null;
		}
		TreeNode node = new TreeNode(token.value);
		this.position += token.size;
		node.left = constructTree(chArr, depth + 1, maxLen);
		node.right = constructTree(chArr, depth + 1, maxLen);
		return node;
	}
	
	
	private Token constructToken(char[] chArr, int idx, int maxLen) {
		if(idx >= maxLen) return null;
		Token token = new Token();
		while(chArr[idx] == '-') {
			token.depth++;
			idx++;
		}
		while(idx < maxLen && Character.isDigit(chArr[idx])) {
			token.value = token.value * 10 + Character.getNumericValue(chArr[idx]);
			token.size++;
			idx++;
		}
		token.size += token.depth;
		return token;
	}
	
	private static class Token{
		int depth;
		int value;
		int size;
	}
}
