package org.pg.march.lc.tree;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.lc.coll.TreeNode;
import org.pg.march.util.TreeUtil;

import junit.framework.Assert;

public class BinaryTreeCamerasTest {

	private BinaryTreeCameras binaryTreeCameras;

	@Before
	public void setup() {
		binaryTreeCameras = new BinaryTreeCameras();
	}

	@Test
	public void testcase1() {
		Integer[] bfBinaryTree = { 0, 0, null, 0, 0 };
		TreeNode root = TreeUtil.createBinaryTreeWithBreadthFirst(bfBinaryTree);
		Assert.assertEquals(1, binaryTreeCameras.minCameraCover(root));
	}

	@Test
	public void testcase2() {
		Integer[] bfBinaryTree = { 0, 0, null, 0, null, 0, null, null, 0 };
		TreeNode root = TreeUtil.createBinaryTreeWithBreadthFirst(bfBinaryTree);
		Assert.assertEquals(2, binaryTreeCameras.minCameraCover(root));
	}
}
