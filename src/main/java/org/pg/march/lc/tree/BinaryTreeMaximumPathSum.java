package org.pg.march.lc.tree;

import org.pg.march.lc.coll.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {

	private int result;

	public int maxPathSum(TreeNode root) {
		result = Integer.MIN_VALUE;
		maxGain(root);
		return result;
	}

	private int maxGain(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftGain = Math.max(0, maxGain(node.left));
		int rightGain = Math.max(0, maxGain(node.right));
		int gain = node.val + leftGain + rightGain;
		result = Math.max(result, gain);
		return Math.max(leftGain, rightGain) + node.val;
	}

}
