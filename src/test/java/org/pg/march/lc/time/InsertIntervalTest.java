package org.pg.march.lc.time;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class InsertIntervalTest {

	private InsertInterval insertInterval;

	@Before
	public void setup() {
		insertInterval = new InsertInterval();
	}

	@Test
	public void testcase1() {
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[][] newIntervals = insertInterval.insert(intervals, new int[] { 2, 5 });
		int[][] expected = { { 1, 5 }, { 6, 9 } };
		Assert.assertTrue(Arrays.deepEquals(expected, newIntervals));
	}

	@Test
	public void testcase2() {
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[][] newIntervals = insertInterval.insert(intervals, new int[] { 4, 8 });
		int[][] expected = { { 1, 2 }, { 3, 10 }, { 12, 16 } };
		Assert.assertTrue(Arrays.deepEquals(expected, newIntervals));
	}
}
