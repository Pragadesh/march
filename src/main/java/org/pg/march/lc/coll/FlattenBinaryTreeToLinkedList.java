package org.pg.march.lc.coll;

/*
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        
//        if(root != null) {
//            rightAlign(root);
//        }
        flatten(root, null);
    }
    
    
    private TreeNode flatten(TreeNode root, TreeNode prev) {
        if( root == null) {
            return prev;
        }
        prev = flatten(root.right, prev);
        prev = flatten(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root;
        return prev;
    }
    
    
    private TreeNode rightAlign(TreeNode root) {
        TreeNode newRightLeaf = root;
        TreeNode rightNode = root.right;
        if(root.left != null) {
            newRightLeaf.right = root.left;
            newRightLeaf = rightAlign(root.left);
            root.left = null;
        }
        if(rightNode != null) {
            newRightLeaf.right = rightNode;
            newRightLeaf = rightAlign(rightNode);
        }
        return newRightLeaf;
    }
}
