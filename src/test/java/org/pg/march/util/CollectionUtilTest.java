package org.pg.march.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Assert;
import org.pg.march.lc.coll.ListNode;
import org.pg.march.lc.coll.Node;
import org.pg.march.lc.coll.TreeNode;

public class CollectionUtilTest {

    /**
     * @deprecated Use {@link CollectionUtil#_HASH} instead
     */
    public static final String _HASH = CollectionUtil._HASH;

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
		if(head == null) {return null;}
		while(head.next != null) {
			head = head.next;
		}
		return head;
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
