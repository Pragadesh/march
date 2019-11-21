package org.pg.march.lc.coll;

/*
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) {
            return head;
        }
        if(n == 1 && head.next == null) {
            return null;
        }
        ListNode start = head;
        ListNode trailingNode = head;
        int size = 0;
        while (head != null) {
            if (n - size < 0) {
                trailingNode = trailingNode.next;
            }
            head = head.next;
            size++;
        }
        if (size > n) {
            trailingNode.next = trailingNode.next.next;
        }else if(size == n) {
            return start.next;
        }

        return start;
    }

}
