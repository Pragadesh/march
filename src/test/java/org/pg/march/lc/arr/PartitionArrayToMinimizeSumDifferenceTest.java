package org.pg.march.lc.arr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class PartitionArrayToMinimizeSumDifferenceTest {

    private PartitionArrayToMinimizeSumDifference minimizeSumDifference;

    @Before
    public void setup() {
        minimizeSumDifference = new PartitionArrayToMinimizeSumDifference();
    }

    @Test
    public void testcase1() {
        int[] nums = {3,9,7,3};
        Assert.assertEquals(2, minimizeSumDifference.minimumDifference(nums));
    }

    @Test
    public void testcase2() {
        int[] nums = {-36,36};
        Assert.assertEquals(72, minimizeSumDifference.minimumDifference(nums));
    }

    @Test
    public void testcase3() {
        int[] nums = {2,-1,0,4,-2,-9};
        Assert.assertEquals(0, minimizeSumDifference.minimumDifference(nums));
    }

    @Test
    public void testcase4() {
        int[] nums = {2,-1,0,4,-2,-9};
        int[][] result1 = minimizeSumDifference.generateOriginal(Arrays.copyOfRange(nums, 0, nums.length/2));
//        int[][] result2 = minimizeSumDifference.generateOriginal(Arrays.copyOfRange(nums, nums.length/2, nums.length));
        System.out.println(result1);
    }
}
