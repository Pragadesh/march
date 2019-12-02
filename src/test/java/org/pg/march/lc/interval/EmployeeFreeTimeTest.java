package org.pg.march.lc.interval;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import junit.framework.Assert;

public class EmployeeFreeTimeTest {

	private EmployeeFreeTime employeeFreeTime;

	@Before
	public void setup() {
		employeeFreeTime = new EmployeeFreeTime();
	}

	@Test
	public void testcase1() {
		List<List<Interval>> schedule = new ArrayList<>();
		schedule.add(Lists.newArrayList(new Interval(1, 2), new Interval(5, 6)));
		schedule.add(Lists.newArrayList(new Interval(1, 3)));
		schedule.add(Lists.newArrayList(new Interval(4, 10)));
		List<Interval> freeSlots = employeeFreeTime.employeeFreeTime(schedule);
		List<Interval> expected = Lists.newArrayList(new Interval(3, 4));
		Assert.assertTrue(expected.equals(freeSlots));
	}

	@Test
	public void testcase2() {
		List<List<Interval>> schedule = new ArrayList<>();
		schedule.add(Lists.newArrayList(new Interval(1, 3), new Interval(6, 7)));
		schedule.add(Lists.newArrayList(new Interval(2, 4)));
		schedule.add(Lists.newArrayList(new Interval(2, 5), new Interval(9, 12)));
		List<Interval> freeSlots = employeeFreeTime.employeeFreeTime(schedule);
		List<Interval> expected = Lists.newArrayList(new Interval(5, 6), new Interval(7, 9));
		Assert.assertTrue(expected.equals(freeSlots));
	}
}
