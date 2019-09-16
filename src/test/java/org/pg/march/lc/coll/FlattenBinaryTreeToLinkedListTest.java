package org.pg.march.lc.coll;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtil;
import org.pg.march.util.CollectionUtilTest;

public class FlattenBinaryTreeToLinkedListTest {

    private FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList;

    @Before
    public void setup() {
        flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
    }

    @Test
    public void testcase1() {
        TreeNode root = CollectionUtil.createBinaryTreeWithBreadthFirst(new String[] { "1", "2", "5", "3", "4", "#", "6" });
        flattenBinaryTreeToLinkedList.flatten(root);
        CollectionUtilTest.assertTree(new int[] { 1, 2, 3, 4, 5, 6 }, root, false);
    }

    @Test
    public void testcase2() {
        TreeNode root = CollectionUtil.createBinaryTreeWithBreadthFirst(new String[] { "1", "2", "3" });
        flattenBinaryTreeToLinkedList.flatten(root);
        CollectionUtilTest.assertTree(new int[] { 1, 2, 3 }, root, false);
    }

}
