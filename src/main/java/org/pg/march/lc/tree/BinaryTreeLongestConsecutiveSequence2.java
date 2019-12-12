package org.pg.march.lc.tree;

import org.pg.march.lc.coll.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/
 */
public class BinaryTreeLongestConsecutiveSequence2 {

	private int maxLength = 0;

	public int longestConsecutive(TreeNode root) {
		dfs(root);
		return maxLength;
	}

	private Result dfs(TreeNode node) {
		if (node == null) {
			return new Result(0, 0);
		}
		Result left = dfs(node.left);
		Result right = dfs(node.right);
		int val = node.val;
		if (node.left != null && node.right != null) {
			if (val == node.left.val + 1 && val == node.right.val - 1) {
				maxLength = Math.max(maxLength, left.inc + right.dec + 1);
			}
			if (val == node.left.val - 1 && val == node.right.val + 1) {
				maxLength = Math.max(maxLength, left.dec + right.inc + 1);
			}
		}
		int inc = 1;
		int dec = 1;
		if (node.left != null) {
			if (val == node.left.val + 1) {
				inc = left.inc + 1;
			} else if (val == node.left.val - 1) {
				dec = left.dec + 1;
			}
		}
		if (node.right != null) {
			if (val == node.right.val + 1) {
				inc = Math.max(inc, right.inc + 1);
			} else if (val == node.right.val - 1) {
				dec = Math.max(dec, right.dec + 1);
			}
		}
		maxLength = Math.max(maxLength, Math.max(inc, dec));
		return new Result(inc, dec);
	}

	private static class Result {
		int inc;
		int dec;

		public Result(int inc, int dec) {
			this.inc = inc;
			this.dec = dec;
		}
	}
}
