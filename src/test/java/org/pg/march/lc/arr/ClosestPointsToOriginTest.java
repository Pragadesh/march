package org.pg.march.lc.arr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ClosestPointsToOriginTest {

    private ClosestPointsToOrigin closestPointsToOrigin;

    @Before
    public void setup() {
        closestPointsToOrigin = new ClosestPointsToOrigin();
    }

    @Test
    public void testcase1() {
        int[][] points = { { 1, 3 }, { -2, 2 } };
        int[][] expResult = { { -2, 2 } };
        int[][] actResult = closestPointsToOrigin.kClosest(points, 1);
        validateEquals(expResult, actResult);
    }

    @Test
    public void testcase2() {
        int K = 2;
        int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int[][] expResult = { { 3, 3 }, { -2, 4 } };
        int[][] actResult = closestPointsToOrigin.kClosest(points, K);
        validateEquals(expResult, actResult);
    }

    private void validateEquals(int[][] expResult, int[][] actResult) {
        if (expResult == null || expResult.length == 0) {
            Assert.assertTrue("Actual result must be empty", actResult == null || actResult.length == 0);
        }
        Assert.assertTrue("Actual result cannot be empty", actResult != null && actResult.length > 0);
        Assert.assertEquals("Expected and Actual result size dont match", expResult.length, actResult.length);
        Set<String> actResultSet = pointsToSet(actResult);
        for (String point : pointsToList(expResult)) {
            if (!actResultSet.contains(point)) {
                Assert.fail("Missing point" + point);
            }
        }
    }

    private Set<String> pointsToSet(int[][] points) {
        return new HashSet<>(pointsToList(points));
    }

    private List<String> pointsToList(int[][] points) {
        List<String> pointList = new ArrayList<>();
        if (points != null) {
            for (int[] point : points) {
                pointList.add(pointToString(point));
            }
        }
        return pointList;
    }

    private String pointToString(int[] point) {
        if (point == null || point.length != 2) {
            throw new IllegalArgumentException("Invalid point: " + point);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(point[0]).append(",").append(point[1]);
        return builder.toString();
    }
}
