package org.pg.march.util;

import org.pg.march.lc.coll.Node;
import org.pg.march.lc.coll.TreeNode;

public class TreeUtil {

    public static Node addChild(Node parent, Node child, int position) {
        Node index = parent;
        for (int i = 1; i < position; i++) {
            if (index == null)
                break;
            index = index.next;
        }
        if (index != null) {
            index.child = child;
        }
        return parent;
    }

    public static TreeNode createBinaryTreeWithBreadthFirst(String[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Integer[] numsInteger = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            String val = nums[i];
            numsInteger[i] = (val == null || CollectionUtil._HASH.equals(val)) ? null : Integer.valueOf(nums[i]);
        }
        return TreeUtil.createBinaryTreeBreadthFirst(numsInteger, 0);
    }

    public static TreeNode createBinaryTreeWithBreadthFirst(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return TreeUtil.createBinaryTreeBreadthFirst(nums, 0);
    }

    static TreeNode createBinaryTreeBreadthFirst(Integer[] nums, int pos) {
        TreeNode currNode = null;
        if (pos < nums.length && nums[pos] != null) {
            currNode = new TreeNode(nums[pos]);
            currNode.left = createBinaryTreeBreadthFirst(nums, 2 * pos + 1);
            currNode.right = createBinaryTreeBreadthFirst(nums, 2 * pos + 2);
        }
        return currNode;
    }

}
