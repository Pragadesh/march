package org.pg.march.lc.tree;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.lc.coll.TreeNode;
import org.pg.march.util.CollectionUtilTest;

import junit.framework.Assert;

public class BinaryTreeLongestConsecutiveSequenceTest {

	private BinaryTreeLongestConsecutiveSequence2 binaryTreeLongestConsecutiveSequence;

	@Before
	public void setup() {
		binaryTreeLongestConsecutiveSequence = new BinaryTreeLongestConsecutiveSequence2();
	}

	@Test
	public void testcase1() {
		Integer[] nums = { 1, 2, 3 };
		TreeNode root = CollectionUtilTest.createBinaryTreeWithBreadthFirst(nums);
		Assert.assertEquals(2, binaryTreeLongestConsecutiveSequence.longestConsecutive(root));
	}

	@Test
	public void testcase2() {
		Integer[] nums = { 2, 1, 3 };
		TreeNode root = CollectionUtilTest.createBinaryTreeWithBreadthFirst(nums);
		Assert.assertEquals(3, binaryTreeLongestConsecutiveSequence.longestConsecutive(root));
	}
}
