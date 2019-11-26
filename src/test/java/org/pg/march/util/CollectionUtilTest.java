package org.pg.march.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;
import org.pg.march.lc.coll.ListNode;
import org.pg.march.lc.coll.Node;
import org.pg.march.lc.coll.TreeNode;

public class CollectionUtilTest {

	public static void assertArrayOfArray(Integer[][] expected, Integer[][] actual) {
		if ((actual == null || actual.length == 0) && (expected == null || expected.length == 0)) {
			return;
		}
		if ((actual == null || actual.length == 0) || (expected == null || expected.length == 0)) {
			Assert.fail("One of the list is empty");
		}
		Assert.assertEquals("Number of List", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			Assert.assertArrayEquals("List #" + i, expected[i], actual[i]);
		}
	}

	public static <T> void assertIgnoreOrderList(List<T> expected, List<T> actual) {
		if (expected == null || expected.size() == 0) {
			Assert.assertTrue(actual == null || actual.size() == 0);
			return;
		}
		Assert.assertNotNull("Empty response", actual);
		Assert.assertEquals("List size", expected.size(), actual.size());
		Set<T> actualSet = new HashSet<>(actual);
		for (T exp : expected) {
			Assert.assertTrue(exp.toString(), actualSet.remove(exp));
		}
		Assert.assertTrue("Extra elements: " + actualSet, actualSet.size() == 0);
	}

	public static <T> void assertIgnoreOrderListOfList(List<List<T>> expectedList, List<List<T>> actualList) {
		if (expectedList == null || expectedList.size() == 0) {
			Assert.assertTrue(actualList == null || actualList.size() == 0);
			return;
		}
		Assert.assertNotNull("Empty response", actualList);
		Assert.assertEquals("List size", expectedList.size(), actualList.size());
		Set<String> actualSet = new HashSet<>();
		for (List<T> actual : actualList) {
			actualSet.add(actual.toString());
		}
		for (List<T> expected : expectedList) {
			Assert.assertTrue(expected.toString(), actualSet.remove(expected.toString()));
		}
		Assert.assertTrue("Extra elements: " + actualSet, actualSet.size() == 0);
	}

	public static <T> void assertListOfList(List<List<T>> expectedList, List<List<T>> actualList) {
		if (expectedList == null || expectedList.size() == 0) {
			Assert.assertTrue(actualList == null || actualList.size() == 0);
			return;
		}
		Assert.assertNotNull("Empty response", actualList);
		Assert.assertEquals("List size", expectedList.size(), actualList.size());
		for (int i = 0; i < actualList.size(); i++) {
			Assert.assertTrue(
					String.format("%d th element mismatch E%s vs A%s", i, expectedList.get(i), actualList.get(i)),
					expectedList.get(i).equals(actualList.get(i)));
		}
	}

	public static void assertLinkedList(int[] nums, ListNode head) {
		if (nums == null || nums.length == 0) {
			Assert.assertNull("No nodes expected", head);
			return;
		}
		Assert.assertNotNull(String.format("Expected length: %d, but found empty", nums.length), head);
		int[] actualArr = ArrayUtil.toIntArray(toList(head));
		Assert.assertArrayEquals("Linked list data validation failed", nums, actualArr);
	}

	public static void assertTree(int[] nums, TreeNode root, boolean leanLeft) {
		if (nums == null || nums.length == 0) {
			Assert.assertNull("No nodes expected", root);
			return;
		}
		Assert.assertNotNull(String.format("Expected length: %d, but found empty", nums.length), root);
		int[] actualArr = ArrayUtil.toIntArray(toList(root, leanLeft));
		Assert.assertArrayEquals("Linked list data validation failed", nums, actualArr);
	}

	public static void assertDoubleLinkedList(int[] nums, Node head) {
		if (nums == null || nums.length == 0) {
			Assert.assertNull("No nodes expected", head);
			return;
		}
		Assert.assertNotNull(String.format("Expected length: %d, but found empty", nums.length), head);

		int[] actualArr = ArrayUtil.toIntArray(toList(head, true));
		Assert.assertArrayEquals("Linked list forward data validation failed", nums, actualArr);

		Node tail = tail(head);
		List<Integer> reverseList = toList(tail, false);
		Collections.reverse(reverseList);
		int[] reverseArr = ArrayUtil.toIntArray(reverseList);
		Assert.assertArrayEquals("Linked list reverse data validation failed", nums, reverseArr);
	}

	public static List<Integer> toList(ListNode head) {
		List<Integer> actual = new ArrayList<>();
		while (head != null) {
			actual.add(head.val);
			head = head.next;
		}
		return actual;
	}

	public static List<Integer> toList(Node head, boolean forwardDirection) {
		List<Integer> actual = new ArrayList<>();
		while (head != null) {
			actual.add(head.val);
			head = forwardDirection ? head.next : head.prev;
		}
		return actual;
	}

	public static List<Integer> toList(TreeNode root, boolean leanLeft) {
		List<Integer> actual = new ArrayList<>();
		while (root != null) {
			actual.add(root.val);
			root = leanLeft ? root.left : root.right;
		}
		return actual;
	}

	public static Node tail(Node head) {
		if (head == null) {
			return null;
		}
		while (head.next != null) {
			head = head.next;
		}
		return head;
	}

	public static TreeNode createBinaryTreeWithBreadthFirst(Integer[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return createBinaryTreeBreadthFirst(nums, 0);
	}

	private static TreeNode createBinaryTreeBreadthFirst(Integer[] nums, int pos) {
		TreeNode currNode = null;
		if (pos < nums.length && nums[pos] != null) {
			currNode = new TreeNode(nums[pos]);
			currNode.left = createBinaryTreeBreadthFirst(nums, 2 * pos + 1);
			currNode.right = createBinaryTreeBreadthFirst(nums, 2 * pos + 2);
		}
		return currNode;
	}

	public static String[] breadthFirstTreeTraversal(TreeNode root) {
		List<String> values = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Map<TreeNode, Integer> positionMap = new HashMap<>();
		int pos = 0;
		if (root != null) {
			queue.add(root);
			positionMap.put(root, pos);
		}
		while (!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			int currNodePos = positionMap.remove(currNode);
			while (pos < currNodePos) {
				values.add(CollectionUtil._HASH);
				pos++;
			}
			values.add(Integer.toString(currNode.val));
			if (currNode.left != null) {
				queue.add(currNode.left);
				positionMap.put(currNode.left, 2 * pos + 1);
			}

			if (currNode.right != null) {
				queue.add(currNode.right);
				positionMap.put(currNode.right, 2 * pos + 2);
			}
			pos++;
		}
		String[] nodesBFS = new String[values.size()];
		return values.toArray(nodesBFS);
	}

}
