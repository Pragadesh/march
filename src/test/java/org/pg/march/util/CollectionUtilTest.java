package org.pg.march.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Assert;
import org.pg.march.lc.coll.ListNode;
import org.pg.march.lc.coll.TreeNode;

public class CollectionUtilTest {

    public static final String _HASH = "#";

    public static void assertLinkedList(int[] nums, ListNode head) {
        if (nums == null || nums.length == 0) {
            Assert.assertNull("No nodes expected", head);
            return;
        }
        Assert.assertNotNull(String.format("Expected length: %d, but found empty", nums.length), head);
        List<Integer> actual = toList(head);
        int[] actualArr = new int[actual.size()];
        for (int i = 0; i < actualArr.length; i++) {
            actualArr[i] = actual.get(i);
        }
        Assert.assertArrayEquals("Linked list data validation failed", nums, actualArr);

    }

	public static List<Integer> toList(ListNode head) {
		List<Integer> actual = new ArrayList<>();
        while (head != null) {
            actual.add(head.val);
            head = head.next;
        }
		return actual;
	}

    public static TreeNode createBinaryTreeWithBreadthFirst(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createBinaryTreeBreadthFirst(nums, 0);
    }

    private static TreeNode createBinaryTreeBreadthFirst(int[] nums, int pos) {
        TreeNode currNode = null;
        if (pos < nums.length) {
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
                values.add(_HASH);
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
