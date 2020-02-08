package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class OptimizeWaterDistributionTest {

	private OptimizeWaterDistribution optimizeWaterDistribution;

    @Before
    public void setup() {
        optimizeWaterDistribution = new OptimizeWaterDistribution();
    }

    @Test
    public void testcase1() {
        int[][] pipes = new int[][] {
            {1,2,1},
            {2,3,1}};
        Assert.assertEquals(3, optimizeWaterDistribution.minCostToSupplyWater(3, new int[] {1,2,2}, pipes));
    }
}
