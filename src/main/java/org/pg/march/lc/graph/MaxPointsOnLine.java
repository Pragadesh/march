package org.pg.march.lc.graph;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPointsOnLine {

	public int maxPoints(int[][] points) {
		int maxPoints = 0;
		for (int i = 0; i < points.length; i++) {

			Map<String, Integer> slopeCounter = new HashMap<>();
			int localMax = 0;
			int samePoints = 0;
			for (int j = i + 1; j < points.length; j++) {

				if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
				}

				double slope = slope(points[i], points[j]);
				BigDecimal bdSlope = new BigDecimal(slope).setScale(2, RoundingMode.UP);
				slopeCounter.put("", slopeCounter.getOrDefault(bdSlope, 0) + 1);
				maxPoints = Math.max(maxPoints, slopeCounter.get(bdSlope));
			}
		}

		return maxPoints;
	}

	private double slope(int[] point1, int[] point2) {
		if (point1[0] == point2[0]) {
			return 0d;
		}
		return (point1[1] - point2[1]) / (point1[0] - point2[0]);
	}
}
