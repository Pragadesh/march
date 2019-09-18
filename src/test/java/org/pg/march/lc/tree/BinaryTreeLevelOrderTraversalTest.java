package org.pg.march.lc.tree;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.lc.coll.TreeNode;
import org.pg.march.util.CollectionUtil;
import org.pg.march.util.CollectionUtilTest;
import org.pg.march.util.TreeUtil;

public class BinaryTreeLevelOrderTraversalTest {

    private BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal;

    @Before
    public void setup() {
        binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
    }

    @Test
    public void testcase1() {
        Integer[] bfBinaryTree = { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = TreeUtil.createBinaryTreeWithBreadthFirst(bfBinaryTree);
        List<List<Integer>> traversalList = binaryTreeLevelOrderTraversal.levelOrder(root);
        Integer[][] expected = { { 3 }, { 9, 20 }, { 15, 7 } };
        Integer[][] actual = CollectionUtil.toArray(traversalList);
        CollectionUtilTest.assertArrayOfArray(expected, actual);
        
    }
}
