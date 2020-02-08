package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class NumberOfIslandsTest {

	private NumberOfIslands numberOfIslands;

	@Before
	public void setup() {
		numberOfIslands = new NumberOfIslands();
	}

	@Test
	public void testcase1() {
		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		Assert.assertEquals(1, numberOfIslands.numIslands(grid));
	}

	@Test
	public void testcase2() {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		Assert.assertEquals(3, numberOfIslands.numIslands(grid));
	}
}
