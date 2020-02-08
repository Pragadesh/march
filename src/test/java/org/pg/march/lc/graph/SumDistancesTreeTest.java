package org.pg.march.lc.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumDistancesTreeTest {

	private SumDistancesTree sumDistances;

	@Before
	public void setup() {
		sumDistances = new SumDistancesTree();
	}

	@Test
	public void testcase1() {
		int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
		Assert.assertArrayEquals(new int[] { 8, 12, 6, 10, 10, 10 }, sumDistances.sumOfDistancesInTree(6, edges));
	}
}
