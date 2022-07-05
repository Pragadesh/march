package org.pg.march.lc.arr;

import org.junit.Assert;
import org.junit.Test;

public class MinimumKDifferenceTest {

    MinimumKDifference minimumKDifference = new MinimumKDifference();

    @Test
    public void minimumKDifferenceTest1() {
        Assert.assertEquals(0, minimumKDifference.minimumDifference(new int[] {90}, 1));
    }

    @Test
    public void minimumKDifferenceTest2() {
        Assert.assertEquals(2, minimumKDifference.minimumDifference(new int[] {9,4,1,7}, 2));
    }

}
