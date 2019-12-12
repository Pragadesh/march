package org.pg.march.lc.minimax;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class NimGameTest {

	private NimGame nimGame;

    @Before
    public void setup() {
        nimGame = new NimGame();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(false, nimGame.canWinNim(4));
    }
}
