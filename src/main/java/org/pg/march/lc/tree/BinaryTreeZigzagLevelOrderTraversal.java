package org.pg.march.lc.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.pg.march.lc.coll.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		Deque<TreeNode> deque = new LinkedList<>();
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelRes = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				levelRes.add(node.val);
				if(level % 2 == 0) {
					addFirst(deque, node.left);
					addFirst(deque, node.right);
				}else {
					addFirst(deque, node.right);
					addFirst(deque, node.left);
				}
			}
			res.add(levelRes);
			queue.addAll(deque);
			deque.clear();
			level++;
		}
		
		return res;
	}
	
	private void addFirst(Deque<TreeNode> deque, TreeNode root) {
		if(root != null) {
			deque.addFirst(root);
		}
	}
}
