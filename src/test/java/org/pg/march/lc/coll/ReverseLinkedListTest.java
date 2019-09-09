package org.pg.march.lc.coll;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtil;
import org.pg.march.util.CollectionUtilTest;

import junit.framework.Assert;

public class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList;

    @Before
    public void setup() {
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    public void testCase1() {
        int[] nums = { 1, 2 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        ListNode reverseHead = reverseLinkedList.reverseList(head);
        CollectionUtilTest.assertLinkedList(new int[] { 2, 1 }, reverseHead);
    }

    @Test
    public void testCase2() {
        int[] nums = { 1, 2, 3, 4 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        ListNode reverseHead = reverseLinkedList.reverseList(head);
        CollectionUtilTest.assertLinkedList(new int[] { 4, 3, 2, 1 }, reverseHead);
    }

    @Test
    public void testCase3() {
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        ListNode reverseHead = reverseLinkedList.reverseList(head);
        CollectionUtilTest.assertLinkedList(new int[] { 5, 4, 3, 2, 1 }, reverseHead);
    }

    @Test
    public void testCase4() {
        int[] nums = { 1 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        ListNode reverseHead = reverseLinkedList.reverseList(head);
        CollectionUtilTest.assertLinkedList(new int[] { 1 }, reverseHead);
    }

    @Test
    public void testCase5() {
        int[] nums = {};
        ListNode head = CollectionUtil.createLinkedList(nums);
        ListNode reverseHead = reverseLinkedList.reverseList(head);
        Assert.assertNull("Node must be empty", reverseHead);
    }
}
