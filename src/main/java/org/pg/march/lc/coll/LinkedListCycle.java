package org.pg.march.lc.coll;

public class LinkedListCycle {

    /*
     * https://leetcode.com/problems/linked-list-cycle-ii/
     * https://leetcode.com/problems/linked-list-cycle/
     */
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode find = head;
                while (find != slow) {
                    find = find.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
