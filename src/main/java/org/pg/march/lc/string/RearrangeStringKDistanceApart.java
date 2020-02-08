package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

/*
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/
 */
public class RearrangeStringKDistanceApart {

	public String rearrangeString(String s, int k) {
		if(k == 0) return s;
		StringBuilder builder = new StringBuilder();
		Map<Character, Integer> taskCounter = new HashMap<>();
		for(char task : s.toCharArray()) {
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
			int noOfChars = 0;
			while(!pq.isEmpty() && noOfChars < k) {
				Entry<Character, Integer> entry = pq.poll();
				builder.append(entry.getKey());
				if(entry.getValue() > 1) {
					entry.setValue(entry.getValue() - 1);
					list.add(entry);
				}
				noOfChars++;
			}
			if(noOfChars < k && !list.isEmpty()) return "";
		}
		
		
		return builder.toString();
	}
	
	
}
