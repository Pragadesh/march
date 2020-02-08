package org.pg.march.lc.time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		int res = 0;
		Map<Character, Integer> taskCounter = new HashMap<>();
		for(char task : tasks) {
			taskCounter.put(task, taskCounter.getOrDefault(task, 0) + 1);
		}
		PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> {
			int compare = Integer.compare(b.getValue(), a.getValue());
			if(compare == 0) {
				return Character.compare(a.getKey(), b.getKey());
			}
			return compare;
		});
		List<Entry<Character, Integer>> list = new ArrayList<>();
		list.addAll(taskCounter.entrySet());
		while(!list.isEmpty() || !pq.isEmpty()) {
			pq.addAll(list);
			list.clear();
			int noOfTasks = 0;
			while(!pq.isEmpty() && noOfTasks < n + 1) {
				Entry<Character, Integer> entry = pq.poll();
				if(entry.getValue() > 1) {
					entry.setValue(entry.getValue() - 1);
					list.add(entry);
				}
				noOfTasks++;
			}
			res += list.isEmpty() ? noOfTasks : n + 1;
		}
		return res;
	}
}
