package org.pg.march.lc.greedy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CampusBikesTest {

    private CampusBikes campusBikes;

    @Before
    public void setup() {
        campusBikes = new CampusBikes();
    }

    @Test
    public void testcase1() {
        int[][] workers = { { 0, 0 }, { 2, 1 } };
        int[][] bikes = { { 1, 2 }, { 3, 3 } };
        int[] assigned = campusBikes.assignBikes(workers, bikes);
        int[] expected = new int[] { 1, 0 };
        System.out.println(Arrays.toString(assigned));
        Assert.assertArrayEquals(expected, assigned);
    }

    @Test
    public void testcase2() {
        int[][] workers = { { 0, 0 }, { 1, 1 }, { 2, 0 } };
        int[][] bikes = { { 1, 0 }, { 2, 2 }, { 2, 1 } };
        int[] assigned = campusBikes.assignBikes(workers, bikes);
        int[] expected = new int[] { 0, 2, 1 };
        System.out.println(Arrays.toString(assigned));
        Assert.assertArrayEquals(expected, assigned);
        
    }
}
