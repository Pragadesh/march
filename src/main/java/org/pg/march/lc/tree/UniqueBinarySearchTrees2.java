package org.pg.march.lc.tree;

import java.util.ArrayList;
import java.util.List;

import org.pg.march.lc.coll.TreeNode;

/*
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        return _generateTrees(1, n);
    }

    private List<TreeNode> _generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start == end) {
            trees.add(new TreeNode(start));
        }
        if (start >= end) {
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = _generateTrees(start, i - 1);
            List<TreeNode> rightTrees = _generateTrees(i + 1, end);
            trees.addAll(_merge(leftTrees, rightTrees, i));
        }

        return trees;
    }

    private List<TreeNode> _merge(List<TreeNode> leftTrees, List<TreeNode> rightTrees, int val) {
        List<TreeNode> mergedTrees = new ArrayList<>();
        if (leftTrees.isEmpty()) {
            leftTrees.add(null);
        }
        if (rightTrees.isEmpty()) {
            rightTrees.add(null);
        }

        for (TreeNode leftTree : leftTrees) {
            for (TreeNode rightTree : rightTrees) {
                TreeNode mergeTree = new TreeNode(val);
                mergeTree.left = leftTree;
                mergeTree.right = rightTree;
                mergedTrees.add(mergeTree);
            }
        }

        return mergedTrees;
    }

}
