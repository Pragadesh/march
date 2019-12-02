package org.pg.march.lc.coll;

import java.util.PriorityQueue;

public class MedianFinder {

	PriorityQueue<Integer> first;
	PriorityQueue<Integer> last;

	/** initialize your data structure here. */
	public MedianFinder() {
		first = new PriorityQueue<>((a, b) -> (b - a));
		last = new PriorityQueue<>();
	}

	public void addNum(int num) {
		first.add(num);
		last.add(first.poll());
		if(last.size() > first.size()) {
			first.add(last.poll());
		}
	}

	public double findMedian() {
		double median = first.peek();
		if(first.size() == last.size()) {
			median = (median + last.peek()) / 2;
		}
		return median;
	}
}
