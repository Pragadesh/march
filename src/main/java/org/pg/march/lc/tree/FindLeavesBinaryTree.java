package org.pg.march.lc.tree;

import java.util.ArrayList;
import java.util.List;

import org.pg.march.lc.coll.TreeNode;

public class FindLeavesBinaryTree {

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		processNode(root, result);
		return result;
	}

	private int processNode(TreeNode root, List<List<Integer>> result) {
		if (root == null) return -1;
		int leftIndex = processNode(root.left, result);
		int rightIndex = processNode(root.right, result);
		int currIndex = Math.max(leftIndex, rightIndex) + 1;
		while (result.size() <= currIndex) {
			result.add(new ArrayList<>());
		}
		result.get(currIndex).add(root.val);
		return currIndex;
	}

}
