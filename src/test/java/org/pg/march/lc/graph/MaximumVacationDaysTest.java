package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MaximumVacationDaysTest {

	private MaximumVacationDays maximumVacationDays;

	@Before
	public void setup() {
		maximumVacationDays = new MaximumVacationDays();
	}

	@Test
	public void testcase1() {
		int[][] flights = { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };
		int[][] days = { { 1, 3, 1 }, { 6, 0, 3 }, { 3, 3, 3 } };
		Assert.assertEquals(12, maximumVacationDays.maxVacationDays(flights, days));
	}

	@Test
	public void testcase2() {
		int[][] flights = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int[][] days = { { 1, 1, 1 }, { 7, 7, 7 }, { 7, 7, 7 } };
		Assert.assertEquals(3, maximumVacationDays.maxVacationDays(flights, days));
	}

	@Test
	public void testcase3() {
		int[][] flights = { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };
		int[][] days = { { 7, 0, 0 }, { 0, 7, 0 }, { 0, 0, 7 } };
		Assert.assertEquals(21, maximumVacationDays.maxVacationDays(flights, days));
	}
}
