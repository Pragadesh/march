package org.pg.march.lc.time;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TaskSchedulerTest {

	private TaskScheduler taskScheduler;

	@Before
	public void setup() {
		taskScheduler = new TaskScheduler();
	}

	@Test
	public void testcase1() {
		char[] tasks = {'A','A','A','B','B','B'};
		Assert.assertEquals(8, taskScheduler.leastInterval(tasks, 2));
	}
	
	@Test
	public void testcase2() {
		char[] tasks = {'A','A','A','B','B','B'};
		Assert.assertEquals(6, taskScheduler.leastInterval(tasks, 0));
	}
}
