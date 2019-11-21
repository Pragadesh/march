package org.pg.march.lc.coll;

/*
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevNode = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode nextSlow = slow.next;
            slow.next = prevNode;
            prevNode = slow;
            slow = nextSlow;
        }
        ListNode forward = null;
        ListNode backward = prevNode;
        if(fast == null) {
            forward = slow;
        }else {
            forward = slow.next;
        }
        while(true) {
            if (forward == null && backward == null) {
                return true;
            }
            if (forward == null || backward == null) {
                return false;
            }
            if(forward.val != backward.val) {
                return false;
            }
            forward = forward.next;
            backward = backward.next;
        }
    }
}
