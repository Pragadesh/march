package org.pg.march.lc.tree;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.lc.coll.TreeNode;
import org.pg.march.util.TreeUtil;

import junit.framework.Assert;

public class CountCompleteTreeNodesTest {

	private CountCompleteTreeNodes countCompleteTreeNodes;

	@Before
	public void setup() {
		countCompleteTreeNodes = new CountCompleteTreeNodes();
	}

	@Test
	public void testcase1() {
		Integer[] bfBinaryTree = { 1, 2, 3, 4, 5, 6 };
		TreeNode root = TreeUtil.createBinaryTreeWithBreadthFirst(bfBinaryTree);
		Assert.assertEquals(6, countCompleteTreeNodes.countNodes(root));
	}
}
