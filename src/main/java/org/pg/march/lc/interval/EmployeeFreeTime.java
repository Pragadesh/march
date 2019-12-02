package org.pg.march.lc.interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/employee-free-time/
 */
public class EmployeeFreeTime {

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a.start, b.start)));
		schedule.forEach(e -> pq.addAll(e));
		List<Interval> res = new ArrayList<>();
		Interval prev = pq.poll();
		while (!pq.isEmpty()) {
			if (pq.peek().start > prev.end) {
				res.add(new Interval(prev.end, pq.peek().start));
			}
			if(pq.peek().end > prev.end) {
				prev = pq.peek();
			}
			pq.poll();
		}
		return res;
	}
}
