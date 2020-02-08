package org.pg.march.lc.tree;

import org.pg.march.lc.coll.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-cameras/
 */
public class BinaryTreeCameras {

	private int noOfCameras;
	
	public int minCameraCover(TreeNode root) {
		scanForCameras(root);
		return noOfCameras;
	}
	
	private int scanForCameras(TreeNode root) {
		if(root == null) return 0;
		int leftDepth = scanForCameras(root.left);
		int rightDepth = scanForCameras(root.right);
		if(leftDepth % 2 == rightDepth % 2) {
			noOfCameras += (leftDepth % 2);
			return Math.max(leftDepth, rightDepth) + 1;
		}else {
			noOfCameras++;
			return 1;
		}
		
		
		
	}
}
