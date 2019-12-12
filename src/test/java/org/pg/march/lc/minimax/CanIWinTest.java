package org.pg.march.lc.minimax;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CanIWinTest {

	private CanIWin canIWin;

	@Before
	public void setup() {
		canIWin = new CanIWin();
	}

	@Test
	public void testcase1() {
		Assert.assertEquals(false, canIWin.canIWin(10, 11));
	}
}
