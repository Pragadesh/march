package org.pg.march.lc.tree;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class UniqueBinarySearchTreesTest {

    private UniqueBinarySearchTrees uniqueBinarySearchTrees;

    @Before
    public void setup() {
        uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(2, uniqueBinarySearchTrees.numTrees(2));
        Assert.assertEquals(5, uniqueBinarySearchTrees.numTrees(3));
        Assert.assertEquals(14, uniqueBinarySearchTrees.numTrees(4));
        
        Assert.assertEquals(42, uniqueBinarySearchTrees.numTreesInSolution(5));
        Assert.assertEquals(42, uniqueBinarySearchTrees.numTrees(5));
    }
}
