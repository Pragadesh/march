package org.pg.march.lc.tree;

import org.pg.march.lc.coll.TreeNode;

/*
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {

	public int countNodes(TreeNode root) {
		return countByLeftDepth(root);
	}
//
//	private int countByEndCheck(TreeNode root) {
//		
//	}
	
	private int countByLeftDepth(TreeNode root) {
		int height = height(root);
		if(height <= 1) return height;
		int rightHeight = height(root.right);
		return (rightHeight == height - 1? (1 << height - 1) +  countByLeftDepth(root.right) : (1 << height - 2) +  countByLeftDepth(root.left));
	}

	private int height(TreeNode node) {
		int h = 0;
		while (node != null) {
			h++;
			node = node.left;
		}
		return h;
	}
}
