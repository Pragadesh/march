package org.pg.march.lc.coll;

/*
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;

		ListNode index = dummyNode;
		for (int i = 1; i < m; i++) {
			index = index.next;
		}

		ListNode startReverse = index;
		ListNode endReverse = index.next;
		
		ListNode prev = null;
		index = index.next;
		for (int i = 0; i <= (n - m); i++) {
			ListNode next = index.next;
			index.next = prev;
			prev = index;
			index = next;
		}
		endReverse.next = index;
		startReverse.next = prev;
		

		return dummyNode.next;
	}

	public ListNode reverseBetweenFullTraverse(ListNode head, int m, int n) {
		if (m < 1 || m >= n || head == null) {
			return head;
		}
		ListNode startReversal = null;
		ListNode endReversal = null;
		ListNode prevNode = null;
		ListNode start = head;
		int count = 1;
		while (start != null) {
			ListNode next = start.next;
			if (count == m - 1) {
				startReversal = start;
			}
			if (count == m) {
				endReversal = start;
			}

			if (count > m && count <= n) {
				start.next = prevNode;

			}
			if (count == n) {
				if (startReversal != null) {
					startReversal.next.next = next;
					startReversal.next = start;
				} else {
					endReversal.next = next;
				}

			}
			if (m == 1 && count == n) {
				head = start;
			}
			count++;
			prevNode = start;
			start = next;
		}
		return head;
	}
}
