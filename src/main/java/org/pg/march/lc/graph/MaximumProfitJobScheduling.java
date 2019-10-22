package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 */
public class MaximumProfitJobScheduling {

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		PriorityQueue<IntervalNode> startDatePQ = new PriorityQueue<>(Comparator.comparingInt(IntervalNode::getStart));
		for(int i=0; i<startTime.length; i++) {
			IntervalNode node = new IntervalNode(startTime[i], endTime[i], profit[i]);
			startDatePQ.offer(node);
		}
		
		PriorityQueue<IntervalNode> endDatePQ = new PriorityQueue<>(Comparator.comparingInt(IntervalNode::getEnd));
		while(!startDatePQ.isEmpty()) {
			IntervalNode newStartNode = startDatePQ.poll();
			if(endDatePQ.isEmpty() || endDatePQ.peek().end > newStartNode.start) {
				endDatePQ.offer(newStartNode);
			}
			List<IntervalNode> nodesToAddBack = new ArrayList<>();
			while(!endDatePQ.isEmpty() && endDatePQ.peek().end <= newStartNode.start) {
				IntervalNode endNode = endDatePQ.poll();
				nodesToAddBack.add(endNode);
				IntervalNode newNode = new IntervalNode(newStartNode.start, newStartNode.end, newStartNode.profit + endNode.profit);
				endDatePQ.offer(newNode);
			}
			endDatePQ.addAll(nodesToAddBack);
		}
		
		int maxProfit = 0;
		while(!endDatePQ.isEmpty()) {
			maxProfit = Math.max(maxProfit, endDatePQ.poll().getProfit());
		}
		
		return maxProfit;
	}
	
	
	private static class IntervalNode{
		private final int start;
		private final int end;
		private int profit;
		
		public IntervalNode(int start, int end, int profit) {
			this.start = start;
			this.end = end;
			this.profit = profit;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int getProfit() {
			return profit;
		}

		@Override
		public String toString() {
			return "[start=" + start + ", end=" + end + ", profit=" + profit + "]";
		}

	}
}
