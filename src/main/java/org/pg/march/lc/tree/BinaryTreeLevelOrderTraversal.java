package org.pg.march.lc.tree;

import java.util.ArrayList;
import java.util.List;

import org.pg.march.lc.coll.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversalList = new ArrayList<>();
        traverseByLevel(root, 0, traversalList);
        return traversalList;
    }
    
    private void traverseByLevel(TreeNode root, int level, List<List<Integer>> traversalList) {
        if(root == null) {
            return;
        }
        createListForLevel(traversalList, level);
        traversalList.get(level).add(root.val);
        traverseByLevel(root.left, level + 1, traversalList);
        traverseByLevel(root.right, level + 1, traversalList);
    }
    
    private void createListForLevel(List<List<Integer>> traversalList, int level) {
        while(traversalList.size() <= level) {
            traversalList.add(new ArrayList<>());
        }
    }
    
}
