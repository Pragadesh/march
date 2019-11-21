package org.pg.march.lc.coll;

/*
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
public class BinaryTreeUpsideDown {

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode newRoot = upsideDownBinaryTree(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		return newRoot;
	}

	public TreeNode upsideDownBinaryTreePassParent(TreeNode root) {
		return upsideDownBinaryTree(root, null, null);
	}

	private TreeNode upsideDownBinaryTree(TreeNode root, TreeNode parentNode, TreeNode rightNode) {
		if (root == null) {
			return null;
		}
		TreeNode currentRight = root.right;
		TreeNode currentLeft = root.left;
		root.left = rightNode;
		root.right = parentNode;
		TreeNode newRoot = upsideDownBinaryTree(currentLeft, root, currentRight);
		return (newRoot != null ? newRoot : root);
	}
}
