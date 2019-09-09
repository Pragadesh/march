package org.pg.march.lc.coll;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtil;
import org.pg.march.util.CollectionUtilTest;

public class RemoveNodeFromEndTest {

    private RemoveNodeFromEnd removeNodeFromEnd;

    @Before
    public void setup() {
        removeNodeFromEnd = new RemoveNodeFromEnd();
    }

    @Test
    public void testCase1() {
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        ListNode newHead = removeNodeFromEnd.removeNthFromEnd(head, 2);
        CollectionUtilTest.assertLinkedList(new int[] { 1, 2, 3, 5 }, newHead);
    }

    @Test
    public void testCase2() {
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        ListNode newHead = removeNodeFromEnd.removeNthFromEnd(head, 1);
        CollectionUtilTest.assertLinkedList(new int[] { 1, 2, 3, 4 }, newHead);
    }

    @Test
    public void testCase3() {
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        ListNode newHead = removeNodeFromEnd.removeNthFromEnd(head, 5);
        CollectionUtilTest.assertLinkedList(new int[] { 2, 3, 4, 5 }, newHead);
    }

    @Test
    public void testCase4() {
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        ListNode newHead = removeNodeFromEnd.removeNthFromEnd(head, 6);
        CollectionUtilTest.assertLinkedList(new int[] { 1, 2, 3, 4, 5 }, newHead);
    }
}
