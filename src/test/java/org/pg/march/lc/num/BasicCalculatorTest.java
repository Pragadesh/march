package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BasicCalculatorTest {

	private BasicCalculator basicCalculator;

	@Before
	public void setup() {
		basicCalculator = new BasicCalculator();
	}

	@Test
	public void testcase1() {
		Assert.assertEquals(2, basicCalculator.calculate("1 + 1"));
	}
	
	@Test
	public void testcase2() {
		Assert.assertEquals(3, basicCalculator.calculate(" 2-1 + 2 "));
	}
	
	@Test
	public void testcase3() {
		Assert.assertEquals(23, basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));
	}
	
	@Test
	public void testcase4() {
		Assert.assertEquals(-4, basicCalculator.calculate("1-(5)"));
	}
}
