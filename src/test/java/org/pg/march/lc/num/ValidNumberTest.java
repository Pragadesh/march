package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ValidNumberTest {

	private ValidNumber validNumber;

	@Before
	public void setup() {
		validNumber = new ValidNumber();
	}

	@Test
	public void testcase1() {
		Assert.assertEquals(true, validNumber.isNumber("0"));
	}

	@Test
	public void testcase2() {
		Assert.assertEquals(true, validNumber.isNumber(" 0.1 "));
	}

	@Test
	public void testcase3() {
		Assert.assertEquals(false, validNumber.isNumber("abc"));
	}

	@Test
	public void testcase4() {
		Assert.assertEquals(false, validNumber.isNumber("1 a"));
	}

	@Test
	public void testcase5() {
		Assert.assertEquals(true, validNumber.isNumber("2e10"));
	}

	@Test
	public void testcase6() {
		Assert.assertEquals(true, validNumber.isNumber(" -90e3   "));
	}

	@Test
	public void testcase7() {
		Assert.assertEquals(false, validNumber.isNumber(" 1e"));
	}

	@Test
	public void testcase8() {
		Assert.assertEquals(false, validNumber.isNumber("e3"));
	}

	@Test
	public void testcase9() {
		Assert.assertEquals(true, validNumber.isNumber(" 6e-1"));
	}

	@Test
	public void testcase10() {
		Assert.assertEquals(false, validNumber.isNumber(" 99e2.5 "));
	}

	@Test
	public void testcase11() {
		Assert.assertEquals(true, validNumber.isNumber("53.5e93"));
	}

	@Test
	public void testcase12() {
		Assert.assertEquals(false, validNumber.isNumber(" --6 "));
	}

	@Test
	public void testcase13() {
		Assert.assertEquals(false, validNumber.isNumber("-+3"));
	}

	@Test
	public void testcase14() {
		Assert.assertEquals(false, validNumber.isNumber("95a54e53"));
	}
}
