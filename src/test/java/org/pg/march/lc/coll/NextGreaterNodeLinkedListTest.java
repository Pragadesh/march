package org.pg.march.lc.coll;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtil;

public class NextGreaterNodeLinkedListTest {

    private NextGreaterNodeLinkedList nextGreaterNodeLinkedList;

    @Before
    public void setup() {
        nextGreaterNodeLinkedList = new NextGreaterNodeLinkedList();
    }

    @Test
    public void testCase1() {
        int[] nums = { 2, 1, 5 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        int[] largerNodes = nextGreaterNodeLinkedList.nextLargerNodes(head);
        Assert.assertArrayEquals("Result mismatch", new int[] { 5, 5, 0 }, largerNodes);
    }

    @Test
    public void testCase2() {
        int[] nums = { 2, 7, 4, 3, 5 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        int[] largerNodes = nextGreaterNodeLinkedList.nextLargerNodes(head);
        Assert.assertArrayEquals("Result mismatch", new int[] { 7, 0, 5, 5, 0 }, largerNodes);
    }

    @Test
    public void testCase3() {
        int[] nums = { 1, 7, 5, 1, 9, 2, 5, 1 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        int[] largerNodes = nextGreaterNodeLinkedList.nextLargerNodes(head);
        Assert.assertArrayEquals("Result mismatch", new int[] { 7, 9, 9, 9, 0, 5, 0, 0 }, largerNodes);
    }
}
