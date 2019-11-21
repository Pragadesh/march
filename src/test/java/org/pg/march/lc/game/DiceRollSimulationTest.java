package org.pg.march.lc.game;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DiceRollSimulationTest {

    private DiceRollSimulation diceRollSimulation;

    @Before
    public void setup() {
        diceRollSimulation = new DiceRollSimulation();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(34, diceRollSimulation.dieSimulator(2, new int[] { 1, 1, 2, 2, 2, 3 }));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(30, diceRollSimulation.dieSimulator(2, new int[] { 1, 1, 1, 1, 1, 1 }));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(181, diceRollSimulation.dieSimulator(3, new int[] { 1, 1, 1, 2, 2, 3 }));
    }

    @Test
    public void testcase4() {
        Assert.assertEquals(822005673, diceRollSimulation.dieSimulator(20, new int[] { 8, 5, 10, 8, 7, 2 }));
    }
    
    @Test
    public void testcase5() {
        Assert.assertEquals(753152086, diceRollSimulation.dieSimulator(30, new int[] { 2, 3, 1, 2, 1, 2 }));
    }
}
