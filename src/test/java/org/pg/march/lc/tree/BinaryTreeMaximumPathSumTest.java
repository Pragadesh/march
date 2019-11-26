package org.pg.march.lc.tree;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.lc.coll.TreeNode;
import org.pg.march.util.CollectionUtilTest;

import junit.framework.Assert;

public class BinaryTreeMaximumPathSumTest {

	private BinaryTreeMaximumPathSum binaryTreeMaximumPathSum;

	@Before
	public void setup() {
		binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
	}

	@Test
	public void testcase1() {
		Integer[] nums = { 1, 2, 3 };
		TreeNode root = CollectionUtilTest.createBinaryTreeWithBreadthFirst(nums);
		Assert.assertEquals(6, binaryTreeMaximumPathSum.maxPathSum(root));
	}

	@Test
	public void testcase2() {
		Integer[] nums = { -10, 9, 20, null, null, 15, 7 };
		TreeNode root = CollectionUtilTest.createBinaryTreeWithBreadthFirst(nums);
		Assert.assertEquals(42, binaryTreeMaximumPathSum.maxPathSum(root));
	}

	@Test
	public void testcase3() {
		Integer[] nums = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 };
		TreeNode root = CollectionUtilTest.createBinaryTreeWithBreadthFirst(nums);
		Assert.assertEquals(48, binaryTreeMaximumPathSum.maxPathSum(root));
	}
}
