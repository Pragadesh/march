package org.pg.march.lc.coll;

/*
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInGroup {


	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 1) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		int count = 0;
		ListNode begin = dummy;
		while (head != null) {
			count++;
			if (count % k == 0) {
				begin = _reverse(begin, head);
				head = begin.next;
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}

	private ListNode _reverse(ListNode head, ListNode end) {
		ListNode curr = head.next;
		ListNode prev = null;
		while (curr != end) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		ListNode last = head.next;
		last.next = curr.next;
		curr.next = prev;
		head.next = curr;
		return last;
	}
}
