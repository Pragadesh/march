package org.pg.march.lc.tree;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.lc.coll.TreeNode;

public class RecoverTreeFromPreorderTraversalTest {

	
	private RecoverTreeFromPreorderTraversal recoverTreeFromPreorderTraversal;

    @Before
    public void setup() {
        recoverTreeFromPreorderTraversal = new RecoverTreeFromPreorderTraversal();
    }

    @Test
    public void testcase1() {
    	TreeNode tree = recoverTreeFromPreorderTraversal.recoverFromPreorder("1-2--3--4-5--6--7");
    	System.out.println(tree);
    }
}
