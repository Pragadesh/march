package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BasicCalculator2Test {

	private BasicCalculator2 basicCalculator2;

	@Before
	public void setup() {
		basicCalculator2 = new BasicCalculator2();
	}

	@Test
	public void testcase1() {
		Assert.assertEquals(7, basicCalculator2.calculate("3+2*2"));
	}
	
	@Test
	public void testcase2() {
		Assert.assertEquals(1, basicCalculator2.calculate(" 3/2 "));
	}
	
	@Test
	public void testcase3() {
		Assert.assertEquals(5, basicCalculator2.calculate(" 3+5 / 2 "));
	}
}
