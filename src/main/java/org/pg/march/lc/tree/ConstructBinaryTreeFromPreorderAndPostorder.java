package org.pg.march.lc.tree;

import org.pg.march.lc.coll.TreeNode;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndPostorder {

	
	int preIndex = 0, posIndex = 0;
    public TreeNode constructFromPrePost(int[]pre, int[]post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex])
            root.left = constructFromPrePost(pre, post);
        if (root.val != post[posIndex])
            root.right = constructFromPrePost(pre, post);
        posIndex++;
        return root;
    }
	
	public TreeNode constructFromPrePostFirstTry(int[] pre, int[] post) {
		return constructNode(pre, 0, pre.length - 1);
	}

	private TreeNode constructNode(int[] pre, int start, int end) {
		if (start > end) return null;
		TreeNode node = new TreeNode(pre[start]);
		int leftEnd = start + 1;
		while (leftEnd <= end && pre[leftEnd] < pre[start]) {
			leftEnd++;
		}
		node.left = constructNode(pre, start + 1, leftEnd > end ? end : leftEnd - 1);
		if (leftEnd <= end) {
			node.right = constructNode(pre, leftEnd, end);
		}

		return node;
	}
}
