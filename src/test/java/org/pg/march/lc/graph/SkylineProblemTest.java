package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

import com.google.common.collect.Lists;

public class SkylineProblemTest {

	private SkylineProblem skylineProblem;

	@Before
	public void setup() {
		skylineProblem = new SkylineProblem();
	}

	@Test
	public void testcase1() {
		int[][] buildings = new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
		List<List<Integer>> skyline = skylineProblem.getSkyline(buildings);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Lists.newArrayList(2, 10));
		expected.add(Lists.newArrayList(3, 15));
		expected.add(Lists.newArrayList(7, 12));
		expected.add(Lists.newArrayList(12, 0));
		expected.add(Lists.newArrayList(15, 10));
		expected.add(Lists.newArrayList(20, 8));
		expected.add(Lists.newArrayList(24, 0));
		CollectionUtilTest.assertListOfList(expected, skyline);
	}

	@Test
	public void testcase2() {
		int[][] buildings = new int[][] { { 0, 2, 3 }, { 2, 5, 3 } };
		List<List<Integer>> skyline = skylineProblem.getSkyline(buildings);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Lists.newArrayList(0, 3));
		expected.add(Lists.newArrayList(5, 0));
		CollectionUtilTest.assertListOfList(expected, skyline);
	}

	@Test
	public void testcase3() {
		int[][] buildings = new int[][] { { 2, 9, 10 }, { 9, 12, 15 } };
		List<List<Integer>> skyline = skylineProblem.getSkyline(buildings);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Lists.newArrayList(2, 10));
		expected.add(Lists.newArrayList(9, 15));
		expected.add(Lists.newArrayList(12, 0));
		CollectionUtilTest.assertListOfList(expected, skyline);
	}

	@Test
	public void testcase4() {
		int[][] buildings = new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
		List<List<Integer>> skyline = skylineProblem.getSkyline(buildings);
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Lists.newArrayList(2, 10));
		expected.add(Lists.newArrayList(3, 15));
		expected.add(Lists.newArrayList(7, 12));
		expected.add(Lists.newArrayList(12, 0));
		expected.add(Lists.newArrayList(15, 10));
		expected.add(Lists.newArrayList(20, 8));
		expected.add(Lists.newArrayList(24, 0));
		CollectionUtilTest.assertListOfList(expected, skyline);
	}

}
