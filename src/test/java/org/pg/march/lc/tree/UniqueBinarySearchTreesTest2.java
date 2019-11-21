package org.pg.march.lc.tree;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.lc.coll.TreeNode;

import junit.framework.Assert;

public class UniqueBinarySearchTreesTest2 {

    private UniqueBinarySearchTrees2 uniqueBinarySearchTrees2;

    @Before
    public void setup() {
        uniqueBinarySearchTrees2 = new UniqueBinarySearchTrees2();
    }

    @Test
    public void testcase1() {
        List<TreeNode> generatedTrees = uniqueBinarySearchTrees2.generateTrees(4);
        Integer[][] expected = { { 1, null, 3, 2 }, { 3, 2, null, 1 }, { 3, 1, null, null, 2 }, { 2, 1, 3 }, { 1, null, 2, null, 3 } };
        Assert.assertEquals(expected.length, generatedTrees.size());
    }
}
