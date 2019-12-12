package org.pg.march.lc.time;

import java.util.LinkedList;

/*
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

	public int[][] insert(int[][] intervals, int[] newInterval) {

		LinkedList<int[]> result = new LinkedList<>();

		int newStart = newInterval[0];
		int newEnd = newInterval[1];
		int i = 0;
		int N = intervals.length;
		while (i < N && intervals[i][1] < newStart) {
			result.add(intervals[i++]);
		}

		int intervalStart = newStart;
		int intervalEnd = newEnd;
		while (i < N && newEnd >= intervals[i][0]) {
			intervalStart = Math.min(intervalStart, intervals[i][0]);
			intervalEnd = Math.max(intervalEnd, intervals[i][1]);
			i++;
		}
		result.add(new int[] { intervalStart, intervalEnd });
		
		while(i<N) {
			result.add(intervals[i++]);
		}
		int[][] res = new int[result.size()][2];
		return result.toArray(res);
	}
}
