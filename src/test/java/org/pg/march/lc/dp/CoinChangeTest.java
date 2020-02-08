package org.pg.march.lc.dp;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CoinChangeTest {

	CoinChange coinChange;

	@Before
	public void setup() {
		coinChange = new CoinChange();
	}

	@Test
	public void testcase1() {
		int[] coins = { 1, 2, 5 };
		Assert.assertEquals(3, coinChange.coinChange(coins, 11));
	}

	@Test
	public void testcase2() {
		int[] coins = { 2 };
		Assert.assertEquals(-1, coinChange.coinChange(coins, 3));
	}
	
	@Test
	public void testcase3() {
		int[] coins = { 1 };
		Assert.assertEquals(0, coinChange.coinChange(coins, 0));
	}
}
