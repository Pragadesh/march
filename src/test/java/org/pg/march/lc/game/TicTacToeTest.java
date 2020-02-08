package org.pg.march.lc.game;

import org.junit.Test;

import junit.framework.Assert;

public class TicTacToeTest {

    @Test
    public void testcase1() {
        TicTacToe toe = new TicTacToe(3);
        Assert.assertEquals(0, toe.move(0, 0, 1)); // Returns 0 (no one wins)
        Assert.assertEquals(0, toe.move(0, 2, 2)); // Returns 0 (no one wins)
        Assert.assertEquals(0, toe.move(2, 2, 1)); // Returns 0 (no one wins)
        Assert.assertEquals(0, toe.move(1, 1, 2)); // Returns 0 (no one wins)
        Assert.assertEquals(0, toe.move(2, 0, 1)); // Returns 0 (no one wins)
        Assert.assertEquals(0, toe.move(1, 0, 2)); // Returns 0 (no one wins)
        Assert.assertEquals(1, toe.move(2, 1, 1)); // Returns 1 (player 1 wins)
    }

    @Test
    public void testcase2() {
        TicTacToe toe = new TicTacToe(2);
        Assert.assertEquals(0, toe.move(0, 1, 1)); // Returns 0 (no one wins)
        Assert.assertEquals(0, toe.move(1, 1, 2)); // Returns 0 (no one wins)
        Assert.assertEquals(1, toe.move(1, 0, 1)); // Returns 1 (no one wins)
    }
}
