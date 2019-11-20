package org.pg.march.lc.matrix;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class OddValuesInMatrixTest {

	private OddValuesInMatrix oddValuesInMatrix;

	@Before
	public void setup() {
		oddValuesInMatrix = new OddValuesInMatrix();
	}

	@Test
	public void testcase1() {
		int[][] indices = { { 0, 1 }, { 1, 1 } };
		Assert.assertEquals(6, oddValuesInMatrix.oddCells(2, 3, indices));
	}

	@Test
	public void testcase2() {
		int[][] indices = { { 1, 1 }, { 0, 0 } };
		Assert.assertEquals(0, oddValuesInMatrix.oddCells(2, 2, indices));
	}
}
