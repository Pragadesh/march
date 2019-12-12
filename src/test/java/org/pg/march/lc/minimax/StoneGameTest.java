package org.pg.march.lc.minimax;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class StoneGameTest {

	private StoneGame stoneGame;

	@Before
	public void setup() {
		stoneGame = new StoneGame();
	}

	@Test
	public void testcase1() {
		int[] piles = { 5, 3, 4, 5 };
		Assert.assertEquals(true, stoneGame.stoneGame(piles));
	}
}
