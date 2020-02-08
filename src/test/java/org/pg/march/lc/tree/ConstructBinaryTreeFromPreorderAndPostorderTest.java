package org.pg.march.lc.tree;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.lc.coll.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTest {

	private ConstructBinaryTreeFromPreorderAndPostorder constructBinaryTree;

	@Before
	public void setup() {
		constructBinaryTree = new ConstructBinaryTreeFromPreorderAndPostorder();
	}

	@Test
	public void testcase1() {
		int[] pre = { 5, 3, 1, 4, 8, 6, 9 };
		int[] post = { 1, 4, 3, 6, 9, 8, 5 };
		TreeNode root = constructBinaryTree.constructFromPrePost(pre, post);
	}

	@Test
	public void testcase2() {
		int[] pre = { 1, 2, 3 };
		int[] post = { 3, 2, 1 };
		TreeNode root = constructBinaryTree.constructFromPrePost(pre, post);
	}
}
