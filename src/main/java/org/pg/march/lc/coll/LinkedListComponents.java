package org.pg.march.lc.coll;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/linked-list-components/
 */
public class LinkedListComponents {

	public int numComponents(ListNode head, int[] G) {
		if(G == null) {
			return 0;
		}
		Set<Integer> numSet = Arrays.stream(G).boxed().collect(Collectors.toSet());
		
		boolean prevMatched = false;
		int connected = 0;
		
		while (head != null) {
			if(numSet.remove(head.val)) {
				if(!prevMatched) { // start of connected component when prevMatched toggles from false to true
					connected++;
				}
				prevMatched = true;
			}else {
				prevMatched = false;
			}
			head = head.next;
		}
		return connected;
	}
	
	
	
	
	
}
