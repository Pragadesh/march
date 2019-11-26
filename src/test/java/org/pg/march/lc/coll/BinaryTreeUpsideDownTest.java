package org.pg.march.lc.coll;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

public class BinaryTreeUpsideDownTest {

	private BinaryTreeUpsideDown binaryTreeUpsideDown;

	@Before
	public void setup() {
		binaryTreeUpsideDown = new BinaryTreeUpsideDown();
	}

	@Test
	public void testcase1() {
		Integer[] nums = { 1, 2, 3 };
		TreeNode root = CollectionUtilTest.createBinaryTreeWithBreadthFirst(nums);
		TreeNode upsideRoot = binaryTreeUpsideDown.upsideDownBinaryTree(root);
		String[] upsideRootStr = CollectionUtilTest.breadthFirstTreeTraversal(upsideRoot);
		Assert.assertArrayEquals(new String[] { "2", "3", "1" }, upsideRootStr);
		System.out.println(Arrays.toString(upsideRootStr));
	}

	@Test
	public void testcase2() {
	    Integer[] nums = { 1, 2, 3, 4, 5 };
		TreeNode root = CollectionUtilTest.createBinaryTreeWithBreadthFirst(nums);
		TreeNode upsideRoot = binaryTreeUpsideDown.upsideDownBinaryTree(root);
		String[] upsideRootStr = CollectionUtilTest.breadthFirstTreeTraversal(upsideRoot);
		Assert.assertArrayEquals(new String[] { "4", "5", "2", "#", "#", "3", "1" }, upsideRootStr);
		System.out.println(Arrays.toString(upsideRootStr));
	}
}
