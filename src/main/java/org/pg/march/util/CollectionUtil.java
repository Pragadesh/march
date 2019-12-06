package org.pg.march.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.pg.march.lc.coll.ListNode;
import org.pg.march.lc.coll.Node;
import org.pg.march.lc.coll.TreeNode;

public class CollectionUtil {

    public static final String _HASH = "#";

    public static <T> boolean containsAll(Collection<T> dataList, T... values) {
        if (dataList == null || values == null) {
            return true;
        }
        for (T value : values) {
            if (!dataList.contains(value)) {
                System.out.println("Result does not contain: " + value);
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAll(Collection<T> source, Collection<T> destination) {
        if (source == null && destination == null) {
            return true;
        }
        if (source == null || destination == null) {
            System.out.println("One of the collection is empty.");
            return false;
        }
        if (source.size() != destination.size()) {
            System.out.println("Size of collection do not match");
            return false;
        }
        Iterator<T> itr1 = source.iterator();
        Iterator<T> itr2 = destination.iterator();
        while (itr1.hasNext() || itr2.hasNext()) {
            try {
                T t1 = itr1.next();
                T t2 = itr2.next();
                if (!t1.equals(t2)) {
                    System.out.println(String.format("Mismatched elements", t1, t2));
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        }
        return true;
    }

    public static Integer[][] toArray(List<List<Integer>> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        Integer[][] outer = new Integer[nodes.size()][];
        for (int i = 0; i < nodes.size(); i++) {
            List<Integer> node = nodes.get(i);
            if (node == null || node.size() == 0) {
                outer[i] = new Integer[] {};
            } else {
                outer[i] = new Integer[node.size()];
                node.toArray(outer[i]);
            }
        }
        return outer;
    }

    public static ListNode createLinkedList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode prev = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            prev.next = next;
            prev = next;
        }
        return head;
    }
    
    public static List<Integer> traverseLinkedList(ListNode head) {
    	List<Integer> res = new ArrayList<>();
    	while(head != null) {
    		res.add(head.val);
    		head = head.next;
    	}
    	return res;
    }

    public static Node createDoubleLinkedList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Node head = new Node(nums[0]);
        Node prev = head;
        for (int i = 1; i < nums.length; i++) {
            Node curr = new Node(nums[i]);
            prev.next = curr;
            curr.prev = prev;
            prev = curr;
        }
        return head;
    }
    
    public static TreeNode _copy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newNode = new TreeNode(root.val);
        if (root.left != null) {
            newNode.left = _copy(root.left);
        }
        if (root.right != null) {
            newNode.right = _copy(root.right);
        }
        return newNode;
    }

}
