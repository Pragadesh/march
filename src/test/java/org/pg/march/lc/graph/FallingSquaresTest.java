package org.pg.march.lc.graph;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import junit.framework.Assert;

public class FallingSquaresTest {

	private FallingSquares fallingSquares;

	@Before
	public void setup() {
		fallingSquares = new FallingSquares();
	}

	@Test
	public void testcase1() {
		int[][] positions = new int[][] { { 1, 2 }, { 2, 3 }, { 6, 1 } };
		List<Integer> fallSquares = fallingSquares.fallingSquares(positions);
		List<Integer> expected = Lists.newArrayList(2, 5, 5);
		Assert.assertEquals(expected, fallSquares);
	}

	@Test
	public void testcase2() {
		int[][] positions = new int[][] { { 100, 100 }, { 200, 100 } };
		List<Integer> fallSquares = fallingSquares.fallingSquares(positions);
		List<Integer> expected = Lists.newArrayList(100, 100);
		Assert.assertEquals(expected, fallSquares);
	}
}
